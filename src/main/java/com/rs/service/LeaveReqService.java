package com.rs.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rs.dto.LeaveRequestDTO;

public interface LeaveReqService {



	ResponseEntity<String> applyLeave(LeaveRequestDTO dto);

	ResponseEntity<?> updateLeave(Long id, LeaveRequestDTO dto);

	ResponseEntity<?> deleteLeave(Long id);

	ResponseEntity<List<LeaveRequestDTO>> getAllLeaves();

	ResponseEntity<?> getLeaveById(Long id);

	
	
}
