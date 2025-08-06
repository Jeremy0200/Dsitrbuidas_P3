package espe.edu.ec.microservicio_central.repository;

import espe.edu.ec.microservicio_central.model.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgricultorRepository extends JpaRepository<Agricultor, Long> {
}
