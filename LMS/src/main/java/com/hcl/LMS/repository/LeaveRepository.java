package com.hcl.LMS.repository;
import com.hcl.LMS.entity.LeaveRequest;
import com.hcl.LMS.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByEmployee(Employee employee);

    List<LeaveRequest> findByEmployee_Manager(Employee manager);
}