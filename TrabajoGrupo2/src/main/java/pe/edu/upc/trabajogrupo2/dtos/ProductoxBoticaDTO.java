package pe.edu.upc.trabajogrupo2.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.trabajogrupo2.entities.Botica;
import pe.edu.upc.trabajogrupo2.entities.Producto;

import java.time.LocalDate;

public class ProductoxBoticaDTO {

    private int idProductoxBotica;

    private double precioproducto;

    private LocalDate fechaemision;

    private LocalDate fechavencimiento;

    private Botica botica;

    private Producto producto;


    public int getIdProductoxBotica() {
        return idProductoxBotica;
    }

    public void setIdProductoxBotica(int idProductoxBotica) {
        this.idProductoxBotica = idProductoxBotica;
    }

    public double getPrecioproducto() {
        return precioproducto;
    }

    public void setPrecioproducto(double precioproducto) {
        this.precioproducto = precioproducto;
    }

    public LocalDate getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(LocalDate fechaemision) {
        this.fechaemision = fechaemision;
    }

    public LocalDate getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(LocalDate fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public Botica getBotica() {
        return botica;
    }

    public void setBotica(Botica botica) {
        this.botica = botica;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
