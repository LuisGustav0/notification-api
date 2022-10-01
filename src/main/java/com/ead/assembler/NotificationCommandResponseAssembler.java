package com.ead.assembler;

import com.ead.enums.NotificationStatusE;
import com.ead.models.NotificationModel;
import com.ead.models.response.NotificationCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class NotificationCommandResponseAssembler {

    public NotificationModel toModelWithStatusCreated(final NotificationCommandResponse response) {
        return NotificationModel.builder()
                                .title(response.getTitle())
                                .message(response.getMessage())
                                .userId(response.getUserId())
                                .statusE(NotificationStatusE.CREATED)
                                .build();
    }
}
