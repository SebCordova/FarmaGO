package pe.edu.upc.trabajogrupo2.serviceinterfaces;


import pe.edu.upc.trabajogrupo2.entities.ProductoxBotica;

import java.util.List;

public interface IProductoxBoticaService {

    public List<ProductoxBotica> list();
    public void insert(ProductoxBotica ProdxBot);
    public ProductoxBotica listId(int id);
    public void update(ProductoxBotica ProdxBot);
    public void delete(int id);
}
