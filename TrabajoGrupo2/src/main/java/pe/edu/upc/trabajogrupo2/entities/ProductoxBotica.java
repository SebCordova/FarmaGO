package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ProductoxBotica")
public class ProductoxBotica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProductoxBotica;

    @Column(name = "precioproducto", nullable = false)
    private double precioproducto;
    @Column(name = "fechaemision", nullable = false)
    private LocalDate fechaemision;
    @Column(name = "fechavencimiento", nullable = false)
    private LocalDate fechavencimiento;


    @ManyToOne
    @JoinColumn(name = "idBotica")
    private Botica botica;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;


    public ProductoxBotica() {
    }

    public ProductoxBotica(int idProductoxBotica, double precioproducto, LocalDate fechaemision, LocalDate fechavencimiento, Botica botica, Producto producto) {
        this.idProductoxBotica = idProductoxBotica;
        this.precioproducto = precioproducto;
        this.fechaemision = fechaemision;
        this.fechavencimiento = fechavencimiento;
        this.botica = botica;
        this.producto = producto;
    }

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
