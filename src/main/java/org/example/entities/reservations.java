package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data

public class reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "reservation_id")
    private Long reservationId;
    @Column (name = "book_id")
    private Long bookId;
    @Column (name = "member_id")
    private Long memberId;
    @Column (name = "reservation_date")
    private LocalDateTime reservationDate;
    @Column (name = "return_date")
    private LocalDateTime returnDate;





}
