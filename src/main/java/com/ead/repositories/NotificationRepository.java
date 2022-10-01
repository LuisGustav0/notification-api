package com.ead.repositories;

import com.ead.enums.NotificationStatusE;
import com.ead.models.NotificationModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<NotificationModel, UUID> {

    Page<NotificationModel> findAllByUserIdAndStatusE(UUID userId, NotificationStatusE statusE, Pageable pageable);

    Optional<NotificationModel> findByIdAndUserId(UUID id, UUID userId);
}
