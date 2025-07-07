package com.rs.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.model.Employee;
import com.rs.model.LeaveRequest;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
     Optional<Employee>findByEmailId(String email);
     Optional<Employee> findByMobileNo(String mobileNo);

	
	
}
