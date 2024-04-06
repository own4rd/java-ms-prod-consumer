package br.com.lowlevel.microservice.user.producers;

import br.com.lowlevel.microservice.user.models.EmailDto;
import br.com.lowlevel.microservice.user.models.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user) {
        var emailDto = new EmailDto();
        emailDto.setUserId(user.getUserId());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Cadastrado com sucesso!");
        emailDto.setText(user.getName() + ", seja bem vindo!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);

    }
}
