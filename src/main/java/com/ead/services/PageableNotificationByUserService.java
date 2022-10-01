package com.ead.services;

import com.ead.assembler.NotificationModelAssembler;
import com.ead.enums.NotificationStatusE;
import com.ead.models.NotificationModel;
import com.ead.models.response.NotificationResponse;
import com.ead.models.response.PageNotificationByUserResponse;
import com.ead.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PageableNotificationByUserService {

    private final NotificationRepository repository;

    private final NotificationModelAssembler assembler;

    public PageNotificationByUserResponse call(UUID userId,
                                               @PageableDefault(
                                                       sort = "createdAt",
                                                       direction = Sort.Direction.DESC
                                               ) final Pageable pageable) {

        Page<NotificationModel> pageNotification =
                this.repository.findAllByUserIdAndStatusE(userId, NotificationStatusE.CREATED, pageable);

        final List<NotificationResponse> data = this.assembler.toListResponse(pageNotification.getContent());

        final int pageNumber = pageNotification.getPageable().getPageNumber();
        final int pageSize = pageNotification.getPageable().getPageSize();
        final int totalPages = pageNotification.getTotalPages();
        final long totalElements = pageNotification.getTotalElements();

        return PageNotificationByUserResponse.builder()
                                             .data(data)
                                             .pageNumber(pageNumber)
                                             .pageSize(pageSize)
                                             .totalPages(totalPages)
                                             .totalElements(totalElements)
                                             .build();
    }
}
