package com.rs.dto;

import java.util.List;

import com.rs.model.Resignation;

import lombok.Data;

@Data
public class EmployeeDTO {
	private long id;
	private String fullName;
	private String mobileNo;
	private String emailId;
	private String designation;
	private String empId;
	private String role;
	private String status;
	
	private List<LeaveRequestDTO> leaveRequest;
	
	private ResignationDto resignation;
}
