package pe.edu.upc.trabajogrupo2.dtos;

public class ProductoVendidoxBoticaDTO {

    private int Botica;
    private String NombreB;
    private int ProductoVendido;
    private String NombreP;

    public String getNombreB() {
        return NombreB;
    }

    public void setNombreB(String nombreB) {
        NombreB = nombreB;
    }

    public String getNombreP() {
        return NombreP;
    }

    public void setNombreP(String nombreP) {
        NombreP = nombreP;
    }

    public int getBotica() {
        return Botica;
    }

    public void setBotica(int botica) {
        Botica = botica;
    }

    public int getProductoVendido() {
        return ProductoVendido;
    }

    public void setProductoVendido(int productoVendido) {
        ProductoVendido = productoVendido;
    }
}
