package com.notifier.controller;

import com.notifier.NotificationService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class NotificationController {
    @Resource
    NotificationService notificationService;

    @GetMapping(value = "/notification")
    public void triggerNotification(){
        notificationService.showMacNotification("Hello from Controller");
    }
}
