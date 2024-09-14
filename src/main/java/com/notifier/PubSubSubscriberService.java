package com.notifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
@Slf4j
public class PubSubSubscriberService {

    @Resource
    private PubSubTemplate pubSubTemplate;
    @Resource
    private NotificationService notificationService;

    @Value("${spring.cloud.gcp.pubsub.subscription-id}")
    private String subscriptionId;

    @Autowired
    @Lazy
    public PubSubSubscriberService(PubSubTemplate pubSubTemplate, NotificationService notificationService) {
        this.pubSubTemplate = pubSubTemplate;
        this.notificationService = notificationService;
    }

    @PostConstruct
    public void subscribe() {
        pubSubTemplate.subscribe(subscriptionId, message -> {
            String payload = message.getPubsubMessage().getData().toStringUtf8();
            log.info("Message received: {}", payload);
            notificationService.showMacNotification(payload);
            message.ack();
        });
    }
}
