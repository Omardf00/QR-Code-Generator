package com.omar.qr.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "user_detail")
@Data
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_detail_id")
    private int userDetailId;

    @Column(length = 255)
    private String lastName;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 255)
    private String direction;

    @NotNull
    @NotBlank
    private Date dateOfBirth;

}
