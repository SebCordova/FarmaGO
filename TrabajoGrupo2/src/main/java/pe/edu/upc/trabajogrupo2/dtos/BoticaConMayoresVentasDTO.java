package pe.edu.upc.trabajogrupo2.dtos;

public class BoticaConMayoresVentasDTO {

    private int idBotica;
    private String nombreBotica;
    private double Monto;

    public String getNombreBotica() {
        return nombreBotica;
    }

    public void setNombreBotica(String nombreBotica) {
        this.nombreBotica = nombreBotica;
    }

    public int getIdBotica() {
        return idBotica;
    }

    public void setIdBotica(int idBotica) {
        this.idBotica = idBotica;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double monto) {
        Monto = monto;
    }
}