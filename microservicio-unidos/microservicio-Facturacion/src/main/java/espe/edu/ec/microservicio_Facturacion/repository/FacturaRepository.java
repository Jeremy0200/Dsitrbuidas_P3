package espe.edu.ec.microservicio_Facturacion.repository;

import espe.edu.ec.microservicio_Facturacion.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
