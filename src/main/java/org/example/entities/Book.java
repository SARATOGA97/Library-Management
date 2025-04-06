package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.example.staticdata.Genre;
import org.hibernate.annotations.Columns;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private Long bookId;
    @Column(name="title")
    private String bookTitle;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @Column(name="published_date")
    private LocalDateTime publishedDate;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;






}
