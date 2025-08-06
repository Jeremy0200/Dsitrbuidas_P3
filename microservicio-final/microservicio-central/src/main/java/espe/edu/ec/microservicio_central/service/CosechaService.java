package espe.edu.ec.microservicio_central.service;

import espe.edu.ec.microservicio_central.model.Cosecha;
import espe.edu.ec.microservicio_central.repository.CosechaRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CosechaService {

    private final CosechaRepository cosechaRepository;
    private final RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.routingKey}")
    private String routingKey;

    public CosechaService(CosechaRepository cosechaRepository, RabbitTemplate rabbitTemplate) {
        this.cosechaRepository = cosechaRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    //  Nuevo método para listar todas las cosechas
    public List<Cosecha> listar() {
        return cosechaRepository.findAll();
    }

    // Método para guardar y enviar evento
    public Cosecha guardarCosecha(Cosecha cosecha) {
        Cosecha saved = cosechaRepository.save(cosecha);
        rabbitTemplate.convertAndSend(exchange, routingKey, saved);
        return saved;
    }
}
