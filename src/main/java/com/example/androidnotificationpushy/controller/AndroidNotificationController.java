package com.example.androidnotificationpushy.controller;

import com.example.androidnotificationpushy.model.request.DeviceTokenRequest;
import com.example.androidnotificationpushy.service.AndroidNotificationService;
import com.example.androidnotificationpushy.model.PushyPushRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aosnotification")
@AllArgsConstructor
public class AndroidNotificationController {

    private final AndroidNotificationService androidNotificationService;

    @PostMapping("/{userId}")
    public String sendSamplePush(@RequestBody PushyPushRequest pushyPushRequest, @PathVariable UUID userId){
        androidNotificationService.sendSamplePush(pushyPushRequest, userId);
        return "Success";
    }

    @PostMapping("/token")
    public void saveDeviceToken(@RequestBody DeviceTokenRequest deviceTokenRequest){
        androidNotificationService.saveDeviceToken(deviceTokenRequest);
    }

    @GetMapping("token/user/{userId}")
    public ResponseEntity<?> getDeviceToken(@PathVariable UUID userId){
        return ResponseEntity.status(HttpStatus.OK).body(androidNotificationService.getDeviceToken(userId));
    }
}
