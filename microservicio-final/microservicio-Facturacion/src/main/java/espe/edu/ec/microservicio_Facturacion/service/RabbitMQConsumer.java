package espe.edu.ec.microservicio_Facturacion.service;

import espe.edu.ec.microservicio_Facturacion.model.Factura;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private final FacturaService facturaService;

    @RabbitListener(queues = "cola_facturacion")
    public void recibirInventarioAjustado(Map<String, Object> mensaje) {
        Long cosechaId = Long.parseLong(mensaje.get("cosecha_id").toString());

        Factura factura = new Factura();
        factura.setCosechaId(cosechaId);
        factura.setProducto("Arroz");
        factura.setCantidad(10.0);
        factura.setPrecioUnitario(25.0);
        factura.setTotal(factura.getCantidad() * factura.getPrecioUnitario());

        facturaService.guardar(factura);
    }
}
