package com.hcl.LMS.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    private LocalDate startDate;
    private LocalDate endDate;

    private String reason;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime appliedAt;

    @ManyToOne
    private Employee reviewedBy;

    private LocalDateTime reviewedAt;
}
