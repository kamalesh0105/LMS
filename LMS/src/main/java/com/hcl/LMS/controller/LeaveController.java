package com.hcl.LMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.Authentication;

import java.util.List;

import com.hcl.LMS.service.LeaveService;
import com.hcl.LMS.model.LeaveRequest;

@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/apply")
    public String applyLeave(@RequestBody LeaveRequest req, Authentication auth) {
        return leaveService.applyLeave(auth.getName(), req);
    }

    @GetMapping("/my")
    public List<LeaveRequest> myLeaves(Authentication auth) {
        return leaveService.getMyLeaves(auth.getName());
    }

    @PutMapping("/approve/{id}")
    public String approve(@PathVariable Long id, Authentication auth) {
        return leaveService.approveLeave(id, auth.getName());
    }
}