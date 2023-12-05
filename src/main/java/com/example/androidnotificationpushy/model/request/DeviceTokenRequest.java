package com.example.androidnotificationpushy.model.request;

import com.example.androidnotificationpushy.model.AOSDeviceToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceTokenRequest {
    private UUID userId;
    private String deviceToken;

    public AOSDeviceToken toEntity(){
        return new AOSDeviceToken(null, this.userId, this.deviceToken);
    }
}
