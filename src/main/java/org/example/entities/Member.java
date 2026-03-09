package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "members")
@Data

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "member_id")
    private Long memberId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "membership_date")
    private LocalDate membershipDate;
    @Column(name = "contact_info")
    private String contactInfo;
}
