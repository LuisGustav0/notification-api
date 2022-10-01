package com.ead.assembler;

import com.ead.models.NotificationModel;
import com.ead.models.response.NotificationResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationModelAssembler {

    public NotificationResponse toResponse(final NotificationModel notification) {
        return NotificationResponse.builder()
                                   .id(notification.getId())
                                   .userId(notification.getUserId())
                                   .title(notification.getTitle())
                                   .message(notification.getMessage())
                                   .statusE(notification.getStatusE())
                                   .createdAt(notification.getCreatedAt().toString())
                                   .updatedAt(notification.getUpdatedAt().toString())
                                   .build();
    }

    public List<NotificationResponse> toListResponse(final List<NotificationModel> listNotification) {
        return listNotification.stream().map(this::toResponse).toList();
    }
}
