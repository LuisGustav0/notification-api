package com.ead.services;

import com.ead.models.NotificationModel;
import com.ead.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveNotificationService {

    private final NotificationRepository repository;

    public NotificationModel call(final NotificationModel notification) {
        return this.repository.save(notification);
    }
}
