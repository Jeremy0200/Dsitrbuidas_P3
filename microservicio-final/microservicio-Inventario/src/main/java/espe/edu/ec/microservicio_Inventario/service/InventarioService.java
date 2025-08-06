package espe.edu.ec.microservicio_Inventario.service;

import espe.edu.ec.microservicio_Inventario.model.Insumo;
import espe.edu.ec.microservicio_Inventario.repository.InsumoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final InsumoRepository insumoRepository;

    public void ajustarInventario(String nombreInsumo, double cantidad) {
        insumoRepository.findByNombreInsumo(nombreInsumo).ifPresent(insumo -> {
            insumo.setStock(insumo.getStock() - cantidad);
            insumoRepository.save(insumo);
        });
    }
}