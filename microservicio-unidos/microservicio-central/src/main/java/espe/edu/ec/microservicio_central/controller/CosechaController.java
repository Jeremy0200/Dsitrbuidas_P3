package espe.edu.ec.microservicio_central.controller;

import espe.edu.ec.microservicio_central.model.Cosecha;
import espe.edu.ec.microservicio_central.service.CosechaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cosechas")
public class CosechaController {

    private final CosechaService cosechaService;

    public CosechaController(CosechaService cosechaService) {
        this.cosechaService = cosechaService;
    }

    @GetMapping
    public List<Cosecha> listar() {
        return cosechaService.listar();
    }

    @PostMapping
    public Cosecha crear(@RequestBody Cosecha cosecha) {
        return cosechaService.guardarCosecha(cosecha);
    }
}
