package com.ead.models.response;

import com.ead.enums.NotificationStatusE;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationResponse {

    private UUID id;
    private UUID userId;
    private String title;
    private String message;
    private NotificationStatusE statusE;
    private String createdAt;
    private String updatedAt;
}
