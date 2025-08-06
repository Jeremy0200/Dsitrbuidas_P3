package espe.edu.ec.microservicio_central.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Agricultor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;
}
