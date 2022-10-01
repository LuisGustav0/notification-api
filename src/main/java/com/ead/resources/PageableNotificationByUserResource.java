package com.ead.resources;

import com.ead.models.response.PageNotificationByUserResponse;
import com.ead.services.PageableNotificationByUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class PageableNotificationByUserResource {

    private final PageableNotificationByUserService service;

    @GetMapping("/users/{userId}/notifications")
    public ResponseEntity<PageNotificationByUserResponse> call(@PathVariable UUID userId, final Pageable pageable) {
        final PageNotificationByUserResponse response = this.service.call(userId, pageable);

        return ResponseEntity.ok(response);
    }
}
