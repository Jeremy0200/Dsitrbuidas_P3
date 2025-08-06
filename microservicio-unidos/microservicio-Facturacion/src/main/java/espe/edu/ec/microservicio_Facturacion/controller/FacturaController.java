package espe.edu.ec.microservicio_Facturacion.controller;

import espe.edu.ec.microservicio_Facturacion.model.Factura;
import espe.edu.ec.microservicio_Facturacion.service.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@RequiredArgsConstructor
public class FacturaController {

    private final FacturaService facturaService;

    @GetMapping
    public List<Factura> listar() {
        return facturaService.listar();
    }

    @PostMapping
    public Factura crear(@RequestBody Factura factura) {
        return facturaService.guardar(factura);
    }
}
