package espe.edu.ec.microservicio_Inventario.repository;

import espe.edu.ec.microservicio_Inventario.model.Insumo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InsumoRepository extends MongoRepository<Insumo, String> {
    Optional<Insumo> findByNombreInsumo(String nombreInsumo);
}