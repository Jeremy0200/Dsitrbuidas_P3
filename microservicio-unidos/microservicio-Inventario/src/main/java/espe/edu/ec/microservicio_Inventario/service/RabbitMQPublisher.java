package espe.edu.ec.microservicio_Inventario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RabbitMQPublisher {
    private final RabbitTemplate rabbitTemplate;

    public void publicarInventarioAjustado(Map<String, Object> evento) {
        rabbitTemplate.convertAndSend("inventarioExchange", "inventario_ajustado", evento);
    }
}