package espe.edu.ec.microservicio_Inventario.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "insumos")
public class Insumo {
    @Id
    private String id;
    private String nombreInsumo;
    private double stock; // en kg
    private String unidadMedida;
    private String categoria;
}
