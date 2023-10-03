package com.hf.springbootblogrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    @Column(unique = true,nullable = false)
    private String Title;
    @Column(nullable = false)
    private String description ;
    @Column(nullable = false)
    private String content;
}
