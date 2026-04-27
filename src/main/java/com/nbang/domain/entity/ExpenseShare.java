package com.nbang.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Builder @NoArgsConstructor @AllArgsConstructor
public class ExpenseShare {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String houseId;
    private String userId;
    private long shareAmount;
    private boolean settled;
}