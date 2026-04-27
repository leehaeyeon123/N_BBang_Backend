package com.nbang.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Builder @NoArgsConstructor @AllArgsConstructor
public class HouseMember {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String houseId;
    private String userId;
    @Enumerated(EnumType.STRING)
    private Role role;
    public enum Role { OWNER, MEMBER }
}