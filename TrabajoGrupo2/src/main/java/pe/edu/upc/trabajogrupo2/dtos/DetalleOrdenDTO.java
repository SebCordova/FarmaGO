package pe.edu.upc.trabajogrupo2.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.trabajogrupo2.entities.OrdenCompra;
import pe.edu.upc.trabajogrupo2.entities.ProductoxBotica;

public class DetalleOrdenDTO {

    private int idDetalleOrden;


    private int cantidadProducto;

    private double precioxCantidadProducto;


    private OrdenCompra Ocompra;


    private ProductoxBotica PxBotica;


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
