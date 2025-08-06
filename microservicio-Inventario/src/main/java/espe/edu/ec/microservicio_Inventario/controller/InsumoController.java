package espe.edu.ec.microservicio_Inventario.controller;

import espe.edu.ec.microservicio_Inventario.model.Insumo;
import espe.edu.ec.microservicio_Inventario.repository.InsumoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insumos")
@RequiredArgsConstructor
public class InsumoController {

    private final InsumoRepository insumoRepository;

    @GetMapping
    public List<Insumo> listar() {
        return insumoRepository.findAll();
    }

    @PostMapping
    public Insumo crear(@RequestBody Insumo insumo) {
        return insumoRepository.save(insumo);
    }
}