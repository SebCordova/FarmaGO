package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "DetalleOrden")
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleOrden;

    @Column(name = "precioproducto", nullable = false)
    private int cantidadProducto;
    @Column(name = "fechaemision", nullable = false)
    private double precioxCantidadProducto;

    @ManyToOne
    @JoinColumn(name = "idOrdenCompra")
    private OrdenCompra Ocompra;

    @ManyToOne
    @JoinColumn(name = "idProductoxBotica")
    private ProductoxBotica PxBotica;

    public DetalleOrden() {
    }

    public DetalleOrden(int idDetalleOrden, int cantidadProducto, double precioxCantidadProducto, OrdenCompra ocompra, ProductoxBotica pxBotica) {
        this.idDetalleOrden = idDetalleOrden;
        this.cantidadProducto = cantidadProducto;
        this.precioxCantidadProducto = precioxCantidadProducto;
        Ocompra = ocompra;
        PxBotica = pxBotica;
    }


    public int getIdDetalleOrden() {
        return idDetalleOrden;
    }

    public void setIdDetalleOrden(int idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioxCantidadProducto() {
        return precioxCantidadProducto;
    }

    public void setPrecioxCantidadProducto(double precioxCantidadProducto) {
        this.precioxCantidadProducto = precioxCantidadProducto;
    }

    public OrdenCompra getOcompra() {
        return Ocompra;
    }

    public void setOcompra(OrdenCompra ocompra) {
        Ocompra = ocompra;
    }

    public ProductoxBotica getPxBotica() {
        return PxBotica;
    }

    public void setPxBotica(ProductoxBotica pxBotica) {
        PxBotica = pxBotica;
    }
}
