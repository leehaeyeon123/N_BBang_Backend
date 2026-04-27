package com.nbang.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Builder @NoArgsConstructor @AllArgsConstructor
public class Settlement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String houseId;
    private String fromUserId;
    private String toUserId;
    private long amount;
    @Enumerated(EnumType.STRING)
    private Status status;
    public enum Status { PENDING, COMPLETED, NONE }
}