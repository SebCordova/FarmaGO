package pe.edu.upc.trabajogrupo2.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Botica")
public class Botica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBotica;

    @Column(name = "nombreBotica", nullable = false, length = 30)
    private String nombreBotica;
    @Column(name = "ubicacionBotica", nullable = false, length = 50)
    private String ubicacionBotica;
    @Column(name = "latitudBotica", nullable = false, length = 20)
    private String latitudBotica;
    @Column(name = "longitudBotica", nullable = false, length = 20)
    private String longitudBotica;

    @ManyToOne
    @JoinColumn(name = "idDistrito")
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Botica() {}

    public Botica(int idBotica, String nombreBotica, String ubicacionBotica, String latitudBotica, String longitudBotica, Distrito distrito, Usuario usuario) {
        this.idBotica = idBotica;
        this.nombreBotica = nombreBotica;
        this.ubicacionBotica = ubicacionBotica;
        this.latitudBotica = latitudBotica;
        this.longitudBotica = longitudBotica;
        this.distrito = distrito;
        this.usuario = usuario;
    }

    public int getIdBotica() {
        return idBotica;
    }

    public void setIdBotica(int idBotica) {
        this.idBotica = idBotica;
    }

    public String getNombreBotica() {
        return nombreBotica;
    }

    public void setNombreBotica(String nombreBotica) {
        this.nombreBotica = nombreBotica;
    }

    public String getUbicacionBotica() {
        return ubicacionBotica;
    }

    public void setUbicacionBotica(String ubicacionBotica) {
        this.ubicacionBotica = ubicacionBotica;
    }

    public String getLatitudBotica() {
        return latitudBotica;
    }

    public void setLatitudBotica(String latitudBotica) {
        this.latitudBotica = latitudBotica;
    }

    public String getLongitudBotica() {
        return longitudBotica;
    }

    public void setLongitudBotica(String longitudBotica) {
        this.longitudBotica = longitudBotica;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
