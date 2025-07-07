package com.rs.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rs.dto.EmployeeDTO;

public interface EmployeeService {
	public ResponseEntity<String> save(EmployeeDTO employeeDTO);

	public ResponseEntity<List<EmployeeDTO>> getAll();

	public ResponseEntity<?> getById(long id);

	public ResponseEntity<?> deleteById(long id);

	public ResponseEntity<?> updateById(long id, EmployeeDTO data);





}
