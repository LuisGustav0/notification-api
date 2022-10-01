package com.ead.services;

import com.ead.exceptions.NotificationNotFoundException;
import com.ead.models.NotificationModel;
import com.ead.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationByIdAndUserOrElseThrowService {

    private final NotificationRepository repository;

    public NotificationModel call(final UUID id, final UUID userId) {
        return repository.findByIdAndUserId(id, userId)
                .orElseThrow(NotificationNotFoundException::new);
    }
}
