package co.edu.unicauca.events.infrastructure.output.publisher;

import co.edu.unicauca.events.infrastructure.output.publisher.DTO.PersonDTO;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {

    private final String exchangeName = "exchangeSendEvent";
    private final String routingKey = "email";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendEmail(PersonDTO chair){
        rabbitTemplate.convertAndSend(exchangeName,routingKey, chair);
    }
}
