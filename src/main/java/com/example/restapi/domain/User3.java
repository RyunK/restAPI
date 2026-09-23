package com.example.restapi.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User3 {

    @Id
    private String userid;

    @Column(nullable=false)
    private String passwd;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String email;

    @CreationTimestamp
    @Column(nullable=false, updatable=false)
    private LocalDateTime createdAt;

}
