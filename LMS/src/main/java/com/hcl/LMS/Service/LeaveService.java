package com.hcl.LMS.Service;
import com.hcl.LMS.entity.*;
import com.hcl.LMS.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private LeaveRepository leaveRepo;

    public String applyLeave(String email, LeaveRequest req) {

        Employee emp = empRepo.findByEmail(email).orElseThrow();

        req.setEmployee(emp);
        req.setStatus(Status.PENDING);
        req.setAppliedAt(LocalDateTime.now());

        leaveRepo.save(req);

        return "Leave Applied";
    }

    public List<LeaveRequest> myLeaves(String email) {
        Employee emp = empRepo.findByEmail(email).orElseThrow();
        return leaveRepo.findByEmployee(emp);
    }

    public List<LeaveRequest> managerRequests(String email) {
        Employee manager = empRepo.findByEmail(email).orElseThrow();
        return leaveRepo.findByEmployee_Manager(manager);
    }

    public String approve(Long id, String email) {

        LeaveRequest leave = leaveRepo.findById(id).orElseThrow();
        Employee manager = empRepo.findByEmail(email).orElseThrow();

        leave.setStatus(Status.APPROVED);
        leave.setReviewedBy(manager);
        leave.setReviewedAt(LocalDateTime.now());

        leaveRepo.save(leave);

        return "Approved";
    }
}