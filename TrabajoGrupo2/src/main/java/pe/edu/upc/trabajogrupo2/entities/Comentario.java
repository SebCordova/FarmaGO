package pe.edu.upc.trabajogrupo2.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;

    @Column(name = "detalleComentario", nullable = false, length = 100)
    private String detalleComentario;
    @Column(name = "fechaComentario", nullable = false)
    private LocalDate fechaComentario;

    @ManyToOne
    @JoinColumn(name = "idProductoxBotica")
    private ProductoxBotica PxBotica;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Comentario() {
    }

    public Comentario(int idComentario, String detalleComentario, LocalDate fechaComentario, ProductoxBotica pxBotica, Usuario usuario) {
        this.idComentario = idComentario;
        this.detalleComentario = detalleComentario;
        this.fechaComentario = fechaComentario;
        PxBotica = pxBotica;
        this.usuario = usuario;
    }


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
