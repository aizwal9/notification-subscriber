package com.notifier;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NotificationService {

    public void showMacNotification(String messageContent){
        try {
            String[] cmd ={
                    "osascript", "-e", "display notification \"" + messageContent + "\" with title \"New Pub/Sub Message\""
            };
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
