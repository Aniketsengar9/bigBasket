package com.bigbasket.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Data
public class ErrorDetails {
    //keep the getter methods as they are required to convert in JSON object
    private LocalDateTime timestamp;
    private String message;

}
