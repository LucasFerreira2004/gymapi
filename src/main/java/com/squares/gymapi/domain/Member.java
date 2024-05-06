package com.squares.gymapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    
    @Column(nullable = false)
    private char gender;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private Integer number;
    
    @Column(nullable = true)
    private String unit;
    
    @Column(name = "zip_code", nullable = false)
    private String zipCode;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private String state;
    
    @Column(nullable = false)
    private String phoneNumber;
    
    @Column(nullable = false)
    private String email;
    
    @Column(name = "join_date")
    private LocalDateTime joinDate;
    
    @Column(nullable = false)
    private String membershipPlan;
    
    @Column(nullable = false)
    private Boolean active;
}
