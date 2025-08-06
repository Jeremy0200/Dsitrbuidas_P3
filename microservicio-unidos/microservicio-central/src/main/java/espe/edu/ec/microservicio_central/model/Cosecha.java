package espe.edu.ec.microservicio_central.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Cosecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producto;
    private Double cantidad;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "agricultor_id")
    private Agricultor agricultor;
}
