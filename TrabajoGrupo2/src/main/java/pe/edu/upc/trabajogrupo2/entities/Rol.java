package pe.edu.upc.trabajogrupo2.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Rol")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "rolUsuario", nullable = false, length = 40)
    private String rolUsuario;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;


    public Rol(){
    }

    public Rol(String rolUsuario, int idRol) {
        this.rolUsuario = rolUsuario;
        this.idRol = idRol;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
