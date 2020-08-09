package com.rabbitmq.demo.consumer;


import com.rabbitmq.client.Channel;
import com.rabbitmq.demo.entity.Mail;
import com.rabbitmq.demo.service.MailService;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @Author ZHUDO2
 * @Date 8/9/2020 5:22 PM
 * @Version 1.0
 */
@Component
public class MailConsumer {
    @Autowired
    MailService mailService;


    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "queue01", durable = "true"), exchange = @Exchange(name = "dong-test", durable = "true", type = "topic"), key = "mail.*"))
    @RabbitHandler
    public void onMailMessage(@Payload Mail mail, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.out.println("-----------get msg------------");
        mailService.sendSimpleMail(mail.getTo(), mail.getSubject(), mail.getContent());
        Long d = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(d, false);
    }
}
