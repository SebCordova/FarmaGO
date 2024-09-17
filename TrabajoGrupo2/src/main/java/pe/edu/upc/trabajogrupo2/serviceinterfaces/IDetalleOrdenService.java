package pe.edu.upc.trabajogrupo2.serviceinterfaces;


import pe.edu.upc.trabajogrupo2.entities.DetalleOrden;

import java.util.List;

public interface IDetalleOrdenService {

    public List<DetalleOrden> list();
    public void insert(DetalleOrden DetOrd);
    public DetalleOrden listId(int id);
    public void update(DetalleOrden DetOrd);
    public void delete(int id);
}
