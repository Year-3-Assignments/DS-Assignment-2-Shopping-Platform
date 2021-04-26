package com.shopping.shoppingapi.controller;

import com.shopping.shoppingapi.model.EnumRole;
import com.shopping.shoppingapi.model.Role;
import com.shopping.shoppingapi.model.User;
import com.shopping.shoppingapi.payload.request.LoginRequest;
import com.shopping.shoppingapi.payload.request.SignupRequest;
import com.shopping.shoppingapi.payload.response.JwtResponse;
import com.shopping.shoppingapi.payload.response.MessageResponse;
import com.shopping.shoppingapi.repository.RoleRepository;
import com.shopping.shoppingapi.repository.UserRepository;
import com.shopping.shoppingapi.security.jwt.JwtUtils;
import com.shopping.shoppingapi.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		System.out.println("username " + signUpRequest.getUsername());
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		User user = new User(signUpRequest.getFirstName(),
				signUpRequest.getLastName(),
				signUpRequest.getPhoneNumber(),
				signUpRequest.getUsername(),
				signUpRequest.getEmail(),
				signUpRequest.getAddress_1(),
				signUpRequest.getAddress_2(),
				signUpRequest.getCity(),
				encoder.encode(signUpRequest.getPassword()));
		System.out.println("ROLE " + signUpRequest.getRole());
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(EnumRole.ROLE_USER).orElseThrow(() -> new RuntimeException("Not Found!"));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
					case "seller":
						Role adminRole = roleRepository.findByName(EnumRole.ROLE_SELLER)
								.orElseThrow(() -> new RuntimeException("Error: Seller Role is not found."));
						roles.add(adminRole);

						break;
					case "buyer":
						Role modRole = roleRepository.findByName(EnumRole.ROLE_BUYER)
								.orElseThrow(() -> new RuntimeException("Error: Buyer Role is not found."));
						roles.add(modRole);

						break;
					default:
						Role userRole = roleRepository.findByName(EnumRole.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: User Role is not found."));
						roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
