package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "BoticaProducto")
public class BoticaProducto {

    @EmbeddedId
    private BoticaProductoId id;

    private int idBotica;
    private int idProducto;
    private double precioProducto;
    private LocalDate fechaEmision;
    private LocalDate fechaVenc;


}
