package com.rs.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.model.Employee;
import com.rs.model.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {

	

	

}
