package espe.edu.ec.microservicio_central.controller;

import espe.edu.ec.microservicio_central.model.Agricultor;
import espe.edu.ec.microservicio_central.repository.AgricultorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agricultores")
public class AgricultorController {

    private final AgricultorRepository agricultorRepository;

    public AgricultorController(AgricultorRepository agricultorRepository) {
        this.agricultorRepository = agricultorRepository;
    }

    @GetMapping
    public List<Agricultor> listar() {
        return agricultorRepository.findAll();
    }

    @PostMapping
    public Agricultor crear(@RequestBody Agricultor agricultor) {
        return agricultorRepository.save(agricultor);
    }
}
