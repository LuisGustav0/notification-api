package com.ead.resources;

import com.ead.models.response.NotificationResponse;
import com.ead.services.UpdateNotificationStatusCreatedByUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UpdateNotificationStatusCreatedByUserResource {

    private final UpdateNotificationStatusCreatedByUserService service;

    @PatchMapping("/users/{userId}/notifications/{notificationId}/created")
    public ResponseEntity<NotificationResponse> call(@PathVariable UUID userId,
                                                     @PathVariable UUID notificationId) {
        final NotificationResponse response = this.service.call(notificationId, userId);

        return ResponseEntity.ok(response);
    }
}
