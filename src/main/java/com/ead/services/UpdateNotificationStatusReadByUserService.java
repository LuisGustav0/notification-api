package com.ead.services;

import com.ead.assembler.NotificationModelAssembler;
import com.ead.enums.NotificationStatusE;
import com.ead.models.NotificationModel;
import com.ead.models.response.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateNotificationStatusReadByUserService {

    private final NotificationByIdAndUserOrElseThrowService notificationByIdAndUserOrElseThrowService;

    private final SaveNotificationService saveNotificationService;

    private final NotificationModelAssembler assembler;

    public NotificationResponse call(UUID id, UUID userId) {
        final NotificationModel notification = this.notificationByIdAndUserOrElseThrowService.call(id, userId);
        notification.setStatusE(NotificationStatusE.READ);

        final NotificationModel notificationSaved = this.saveNotificationService.call(notification);

        return this.assembler.toResponse(notificationSaved);
    }
}
