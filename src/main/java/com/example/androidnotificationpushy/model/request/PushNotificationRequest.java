package com.example.androidnotificationpushy.model.request;

import com.example.androidnotificationpushy.model.dto.TransactionHistoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushNotificationRequest {
    private String title;
    private TransactionHistoryDto body;
}
