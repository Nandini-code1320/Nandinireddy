package com.rs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Data
public class LeaveRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String reason;
	private String startDate;
	private String endDate;
	@Column(name = "mobile_no", nullable = false)
    private String mobileNo;

	private String status;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	@JsonBackReference
	private Employee employee;
	

}
