package pe.edu.upc.trabajogrupo2.dtos;

import java.time.LocalDate;

public class ProductoVencidoDTO {
    private int idProductoxBotica;
    private String NombreProducto;
    private LocalDate fechaVencimiento;

    public int getIdProductoxBotica() {
        return idProductoxBotica;
    }

    public void setIdProductoxBotica(int idProductoxBotica) {
        this.idProductoxBotica = idProductoxBotica;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
