package com.chakri.microservices.webservices.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
    //time stamp
    //message
    //details
//    private Local
    private LocalDateTime timeStamp;
    private String message;
    private String detials;

    public ErrorDetails(LocalDateTime timeStamp, String message, String detials) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.detials = detials;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetials() {
        return detials;
    }
}
