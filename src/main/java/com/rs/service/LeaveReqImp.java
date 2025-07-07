package com.rs.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rs.dto.LeaveRequestDTO;
import com.rs.exception.ResponseNotFound;
import com.rs.model.Employee;
import com.rs.model.LeaveRequest;
import com.rs.repo.EmployeeRepository;
import com.rs.repo.LeaveRequestRepository;

@Service
public class LeaveReqImp implements LeaveReqService {

    @Autowired
    private EmployeeRepository repo;

    @Autowired
    private LeaveRequestRepository repos;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ResponseEntity<String> applyLeave(LeaveRequestDTO dto) {
        Optional<Employee> employee = repo.findByMobileNo(dto.getMobileNo());

        if (employee.isEmpty()) {
            return ResponseEntity.badRequest().body("Employee with mobile number not found");
        }

        LeaveRequest leave = new LeaveRequest();
        leave.setStartDate(dto.getStartDate());
        leave.setEndDate(dto.getEndDate());
        leave.setReason(dto.getReason());
        leave.setMobileNo(dto.getMobileNo());
        leave.setStatus("PENDING");
        leave.setEmployee(employee.get());

        repos.save(leave);
        return ResponseEntity.ok("Leave request submitted");
    }

    @Override
    public ResponseEntity<?> deleteLeave(Long id) {
        if (repos.existsById(id)) {
            repos.deleteById(id);
            return ResponseEntity.ok("Leave deleted");
        }
        return ResponseEntity.badRequest().body("Leave not found");
    }

    @Override
    public ResponseEntity<List<LeaveRequestDTO>> getAllLeaves() {
        List<LeaveRequest> list = repos.findAll();
        List<LeaveRequestDTO> dtoList = list.stream()
                .map(leave -> mapper.map(leave, LeaveRequestDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @Override
    public ResponseEntity<?> getLeaveById(Long id) {
        Optional<LeaveRequest> opt = repos.findById(id);
        if (opt.isPresent()) {
            LeaveRequestDTO dto = mapper.map(opt.get(), LeaveRequestDTO.class);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.badRequest().body("Leave not found");
    }

    @Override
    public ResponseEntity<?> updateLeave(Long id, LeaveRequestDTO dto) {
        LeaveRequest existingLeave = repos.findById(id)
                .orElseThrow(() -> new ResponseNotFound("Leave request with ID " + id + " not found."));

        String currentStatus = existingLeave.getStatus();
        if (!currentStatus.equalsIgnoreCase("request") && !currentStatus.equalsIgnoreCase("pending")) {
            return ResponseEntity.badRequest().body("Cannot update leave with status: " + currentStatus);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate oldEndDate = LocalDate.parse(existingLeave.getEndDate(), formatter);
        LocalDate newStartDate = LocalDate.parse(dto.getStartDate(), formatter);
        if (!newStartDate.isAfter(oldEndDate)) {
            return ResponseEntity.badRequest().body("New start date must be after current end date.");
        }

        existingLeave.setStartDate(dto.getStartDate());
        existingLeave.setEndDate(dto.getEndDate());
        existingLeave.setReason(dto.getReason());
        existingLeave.setStatus(dto.getStatus());

        repos.save(existingLeave);
        return ResponseEntity.ok("Leave request updated successfully.");
    }
}
