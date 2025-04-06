package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="autors")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private Long authorId;
    @Column(name="author_first_name")
    private String authorfirstName;
    @Column(name="author_last_name")
    private String authorlastName;
    @Column(name="author_bio")
    private String authorBio;






}
