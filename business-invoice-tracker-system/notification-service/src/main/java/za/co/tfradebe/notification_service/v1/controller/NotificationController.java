package za.co.tfradebe.notification_service.v1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.tfradebe.notification_service.v1.dto.NotificationResponse;
import za.co.tfradebe.notification_service.v1.dto.SendEmailRequest;

@RestController
@RequestMapping("/notification")
@Slf4j
public class NotificationController {

    @PostMapping("/email")
    public ResponseEntity<NotificationResponse> sendEmail(@RequestBody SendEmailRequest request) {
        return  ResponseEntity.ok(new NotificationResponse());
    }
}
