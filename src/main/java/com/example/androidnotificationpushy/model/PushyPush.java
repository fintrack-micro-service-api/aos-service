package com.example.androidnotificationpushy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushyPush {
    private String to;
    private Object data;
}
