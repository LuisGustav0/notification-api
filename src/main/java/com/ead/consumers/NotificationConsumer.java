package com.ead.consumers;

import com.ead.assembler.NotificationCommandResponseAssembler;
import com.ead.models.NotificationModel;
import com.ead.models.response.NotificationCommandResponse;
import com.ead.services.SaveNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationCommandResponseAssembler assembler;

    private final SaveNotificationService saveNotificationService;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "${ead.broker.queue.notificationCommandQueue.name}", durable = "true"),
                    exchange = @Exchange(
                            value = "${ead.broker.exchange.notificationCommandExchange}",
                            type = ExchangeTypes.TOPIC,
                            ignoreDeclarationExceptions = "true"
                    ),
                    key = "${ead.broker.key.notificationCommandKey}"
            )
    )
    public void listenerUserEvent(@Payload NotificationCommandResponse response) {
        final NotificationModel notificationModel = this.assembler.toModelWithStatusCreated(response);

        this.saveNotificationService.call(notificationModel);
    }
}
