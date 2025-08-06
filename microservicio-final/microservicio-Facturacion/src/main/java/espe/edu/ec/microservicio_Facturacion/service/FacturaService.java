package espe.edu.ec.microservicio_Facturacion.service;

import espe.edu.ec.microservicio_Facturacion.model.Factura;
import espe.edu.ec.microservicio_Facturacion.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public List<Factura> listar() {
        return facturaRepository.findAll();
    }

    public Factura guardar(Factura factura) {
        return facturaRepository.save(factura);
    }
}
