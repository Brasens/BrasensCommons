package com.brasens.repository;

import com.brasens.dtos.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PrivilegeRepository extends JpaRepository<Privilege, UUID> {
    Optional<Privilege> findByName(String name);
}
