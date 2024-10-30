package co.unicauca.email.Email.consumer;


import co.unicauca.email.Email.domain.PersonDTO;
import co.unicauca.email.Email.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    @Autowired
    EmailService emailService;

    @RabbitListener(queues = { "${queue.email}" })
    public void onMessage(PersonDTO chair) {
        emailService.sendEmail(chair);
    }
}
