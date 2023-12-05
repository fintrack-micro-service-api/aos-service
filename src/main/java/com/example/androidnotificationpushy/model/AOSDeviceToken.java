package com.example.androidnotificationpushy.model;

import com.example.androidnotificationpushy.model.dto.AOSDeviceTokenDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class AOSDeviceToken {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID userId;
    private String deviceToken;

    public AOSDeviceTokenDto toDto(){
        return new AOSDeviceTokenDto(this.id, this.userId, this.deviceToken);
    }
}
