package co.edu.unicauca.events.publisher;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
public class PublisherConfig {
    @Value("send_Email_toCreator_event")
    private String senderEmail;

    @Bean
    public Queue queueEmail() { return new Queue(senderEmail,true); }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("exchangeSendEvent");
    }

    @Bean
    public Binding binding(Queue myQueue, DirectExchange exchange) {
        return BindingBuilder.bind(myQueue).to(exchange).with("email");
    }
}
