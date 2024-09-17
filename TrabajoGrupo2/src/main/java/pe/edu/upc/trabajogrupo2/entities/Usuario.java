package pe.edu.upc.trabajogrupo2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nomUsuario", nullable = false, length = 40)
    private String nomUsuario;
    @Column(name = "apelUsuario", nullable = false, length = 40)
    private String apelUsuario;
    @Column(name = "dirUsuario", nullable = false, length = 50)
    private String dirUsuario;
    @Column(name = "correoUsuario", nullable = false, length = 50)
    private String correoUsuario;
    @Column(name = "claveUsuario", nullable = false, length = 300)
    private String claveUsuario;
    @Column(name = "habilitado")
    private boolean habilitado;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Rol> roles;

   public Usuario() {

    }

    public Usuario(int idUsuario, String nomUsuario, String apelUsuario, String dirUsuario, String correoUsuario, String claveUsuario, boolean habilitado, List<Rol> roles) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.apelUsuario = apelUsuario;
        this.dirUsuario = dirUsuario;
        this.correoUsuario = correoUsuario;
        this.claveUsuario = claveUsuario;
        this.habilitado = habilitado;
        this.roles = roles;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getApelUsuario() {
        return apelUsuario;
    }

    public void setApelUsuario(String apelUsuario) {
        this.apelUsuario = apelUsuario;
    }

    public String getDirUsuario() {
        return dirUsuario;
    }

    public void setDirUsuario(String dirUsuario) {
        this.dirUsuario = dirUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }


    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
}
