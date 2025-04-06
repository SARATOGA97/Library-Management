package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "members")
@Data

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "members_id")
    private Long membersId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "membership_data")
    private LocalDateTime membershipData;
    @Column(name = "contact_info")
    private String contactInfo;




}
