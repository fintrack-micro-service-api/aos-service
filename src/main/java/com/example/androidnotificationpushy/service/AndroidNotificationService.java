package com.example.androidnotificationpushy.service;

import com.example.androidnotificationpushy.exception.NotFoundException;
import com.example.androidnotificationpushy.model.AOSDeviceToken;
import com.example.androidnotificationpushy.model.PushyPush;
import com.example.androidnotificationpushy.model.dto.AOSDeviceTokenDto;
import com.example.androidnotificationpushy.model.request.DeviceTokenRequest;
import com.example.androidnotificationpushy.repository.AndroidNotificationRepository;
import com.example.androidnotificationpushy.model.PushyAPI;
import com.example.androidnotificationpushy.model.PushyPushRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AndroidNotificationService {

    private final AndroidNotificationRepository androidNotificationRepository;
    public void sendSamplePush(PushyPushRequest pushyPushRequest, UUID userId) {
        String deviceToken = getDeviceToken(userId).getDeviceToken();
        Map<String, String> payload = new HashMap<>();
        payload.put("message", pushyPushRequest.getData());
        PushyPush pushyPush = new PushyPush(deviceToken, payload);
        System.out.println("");
        try {
            PushyAPI.sendPush(pushyPush);
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public void saveDeviceToken(DeviceTokenRequest deviceTokenRequest) {
        androidNotificationRepository.save(deviceTokenRequest.toEntity());
    }

    public AOSDeviceTokenDto getDeviceToken(UUID userId) {
        return androidNotificationRepository.findByUserId(userId).orElseThrow(() -> new NotFoundException("Device not found")).toDto();
    }
}
