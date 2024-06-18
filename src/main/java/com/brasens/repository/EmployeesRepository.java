package com.brasens.repository;

import com.brasens.dtos.Alert;
import com.brasens.dtos.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeesRepository extends JpaRepository<Employees, UUID> {
}
