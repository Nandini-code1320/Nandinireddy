package com.rs.dto;

import com.rs.model.Employee;

import lombok.Data;

@Data
public class LeaveRequestDTO {
	private String id;
	private String reason;
	private String startDate;
	private String endDate;
	private String mobileNo;
	private String status;
   
	private Employee employee;
}
