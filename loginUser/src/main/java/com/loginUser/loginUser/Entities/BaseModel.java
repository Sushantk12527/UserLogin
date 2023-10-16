package com.loginUser.loginUser.Entities;

import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass
@Getter
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long User_Id;


}
