package pe.edu.upc.trabajogrupo2.serviceinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Botica;

import java.util.List;

public interface IBoticaService {
    public List<Botica> list();
    public void insert(Botica botica);
    public Botica listId(int id);
    public void update(Botica botica);
    public void delete(int id);
    public List<Botica> listarBoticasDistrito(int idDistrito);
    public List<String[]> listarDistritoMayorCantBoticas();
}
