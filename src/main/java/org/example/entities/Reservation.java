package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "reservation_id")
    private Long reservationId;
    @Column (name = "reservation_date")
    private LocalDateTime reservationDate;
    @Column (name = "return_date")
    private LocalDateTime returnDate;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;







}
