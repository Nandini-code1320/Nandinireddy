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
import org.springframework.web.bind.annotation.RestController;

import com.rs.dto.EmployeeDTO;
import com.rs.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@PostMapping("/post")
	public ResponseEntity<String> save(@RequestBody EmployeeDTO data)
	{
	          return service.save(data);
	}
	@GetMapping("/get")
	public ResponseEntity<List<EmployeeDTO>>
	getAll(){
		return service.getAll();
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<?>getById(@PathVariable long id)
	{
		return service.getById(id);
	}
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?>deleteById(@PathVariable long id)
	{
		return service.deleteById(id);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?>updateById(@PathVariable long id,@RequestBody EmployeeDTO data )
	{
		return service.updateById(id,data);
	}
	
	
}
	
	
