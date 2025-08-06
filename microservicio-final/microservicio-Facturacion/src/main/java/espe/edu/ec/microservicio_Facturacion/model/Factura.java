package espe.edu.ec.microservicio_Facturacion.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cosechaId;
    private String producto;
    private Double cantidad;
    private Double precioUnitario;
    private Double total;
    private LocalDateTime fechaEmision = LocalDateTime.now();
}
