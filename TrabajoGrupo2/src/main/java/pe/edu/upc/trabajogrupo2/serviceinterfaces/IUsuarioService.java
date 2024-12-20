package pe.edu.upc.trabajogrupo2.serviceinterfaces;

import pe.edu.upc.trabajogrupo2.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public Usuario listId(int id);
    public void update(Usuario usuario);
    public void delete(int id);
    public Usuario listEmail(String email);
}
