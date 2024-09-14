package com.notifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class NotificationService {

    public void showMacNotification(String messageContent) {
        try {
            String notificationCommand = String.format("terminal-notifier -message '%s' -title '%s'", messageContent, "NA");
            Runtime.getRuntime().exec(notificationCommand);
            log.info("Notification gotcha");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
