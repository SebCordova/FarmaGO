package pe.edu.upc.trabajogrupo2.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.trabajogrupo2.entities.ProductoxBotica;
import pe.edu.upc.trabajogrupo2.entities.Usuario;

import java.time.LocalDate;

public class ComentarioDTO {

    private int idComentario;

    private String detalleComentario;

    private LocalDate fechaComentario;

    private ProductoxBotica PxBotica;

    private Usuario usuario;


    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getDetalleComentario() {
        return detalleComentario;
    }

    public void setDetalleComentario(String detalleComentario) {
        this.detalleComentario = detalleComentario;
    }

    public LocalDate getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDate fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public ProductoxBotica getPxBotica() {
        return PxBotica;
    }

    public void setPxBotica(ProductoxBotica pxBotica) {
        PxBotica = pxBotica;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
