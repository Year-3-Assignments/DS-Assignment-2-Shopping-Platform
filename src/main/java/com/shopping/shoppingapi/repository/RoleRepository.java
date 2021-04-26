package com.shopping.shoppingapi.repository;

import com.shopping.shoppingapi.model.EnumRole;
import com.shopping.shoppingapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(EnumRole name);
}
