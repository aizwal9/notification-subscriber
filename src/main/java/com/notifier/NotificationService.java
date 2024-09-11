package com.notifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;

@Service
@Slf4j
public class NotificationService {

    public void showMacNotification(String messageContent){

//        if(SystemTray.isSupported()){
//            try {
//                SystemTray tray = SystemTray.getSystemTray();
//                Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
//
//                TrayIcon trayIcon = new TrayIcon(image, "Notification");
//                trayIcon.setImageAutoSize(true);
//                trayIcon.setToolTip("Notification Demo");
//                tray.add(trayIcon);
//
//                trayIcon.displayMessage("title", messageContent, TrayIcon.MessageType.INFO);
//
//            } catch (AWTException e) {
//                e.printStackTrace();
//            }
//        }else {
//            System.out.println("System tray is not supported!");
//        }
//
        try {
            String notificationCommand = String.format("terminal-notifier -message \"%s\" -title \"%s\"", messageContent, "NA");
            Runtime.getRuntime().exec(notificationCommand);
            log.info("Notification gotcha");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
