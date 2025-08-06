package espe.edu.ec.microservicio_central.repository;

import espe.edu.ec.microservicio_central.model.Cosecha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CosechaRepository extends JpaRepository<Cosecha, Long> {
}
