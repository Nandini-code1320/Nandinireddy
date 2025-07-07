package com.rs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.dto.LeaveRequestDTO;
import com.rs.service.LeaveReqService;

	@RestController
	@RequestMapping("/leave")
	public class LeaveReqController<service> {

	    @Autowired
	    private LeaveReqService service;

	    @PostMapping("/apply")
	    public ResponseEntity<String> applyLeave(@RequestBody LeaveRequestDTO dto) {
	        return service.applyLeave(dto);
	    }

	   
	    @PutMapping("/update/{id}")
	    public ResponseEntity<?> updateLeave(@PathVariable long id, @RequestBody LeaveRequestDTO dto) {
	        return service.updateLeave(id, dto);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteLeave(@PathVariable long id) {
	        return service.deleteLeave(id);
	    }
	    @GetMapping("/all")
	    public ResponseEntity<List<LeaveRequestDTO>> getAllLeaves() {
	        return service.getAllLeaves();
	    }

	    // 5. Get Leave Request by ID
	    @GetMapping("/get/{id}")
	    public ResponseEntity<?> getLeaveById(@PathVariable long id) {
	        return service.getLeaveById(id);
	    }
	    
}

