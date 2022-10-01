package com.ead.exceptions;

import com.ead.enums.ErrorType;

public class NotificationNotFoundException extends ApmException {

    public NotificationNotFoundException() {
        super(ErrorType.NOTIFICATION_NOT_FOUND.getMessage(), ErrorType.NOTIFICATION_NOT_FOUND.toString());
    }
}
