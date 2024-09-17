package pe.edu.upc.trabajogrupo2.serviceinterfaces;


import pe.edu.upc.trabajogrupo2.entities.Comentario;

import java.util.List;

public interface IComentarioService {

    public List<Comentario> list();
    public void insert(Comentario coment);
    public Comentario listId(int id);
    public void update(Comentario coment);
    public void delete(int id);
}
