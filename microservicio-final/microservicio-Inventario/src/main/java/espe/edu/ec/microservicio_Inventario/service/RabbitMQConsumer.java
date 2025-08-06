package espe.edu.ec.microservicio_Inventario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private final InventarioService inventarioService;
    private final RabbitMQPublisher publisher;

    @RabbitListener(queues = "cola_inventario")
    public void recibirEventoNuevaCosecha(Map<String, Object> mensaje) {
        Map<String, Object> payload = (Map<String, Object>) mensaje.get("payload");

        double toneladas = Double.parseDouble(payload.get("cantidad").toString());

        double semillaNecesaria = toneladas * 5;
        double fertilizanteNecesario = toneladas * 2;

        inventarioService.ajustarInventario("Semilla Arroz L-23", semillaNecesaria);
        inventarioService.ajustarInventario("Fertilizante N-PK", fertilizanteNecesario);

        publisher.publicarInventarioAjustado(Map.of(
                "evento", "inventario_ajustado",
                "cosecha_id", payload.get("id"),
                "status", "OK"
        ));
    }
}