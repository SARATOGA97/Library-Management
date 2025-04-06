package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
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
    @Column(name="book_title")
    private String bookTitle;
//    @Column(name="book_genre")
//    private Enum
    @Column(name="book_published_date")
    private LocalDateTime bookPublishedDate;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;





}
