package com.nbang.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Builder @NoArgsConstructor @AllArgsConstructor
public class House {
    @Id
    private String houseId;
    private String name;
    private String inviteCode;
}