package pe.edu.upc.trabajogrupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Comentario;
import pe.edu.upc.trabajogrupo2.entities.Producto;
import pe.edu.upc.trabajogrupo2.repositories.IComentarioRepository;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IComentarioService;

import java.util.List;

@Service
public class ComentarioServiceImplement implements IComentarioService {
    @Autowired
    private IComentarioRepository IComenRepo;

    @Override
    public List<Comentario> list() {
        return IComenRepo.findAll();
    }

    @Override
    public void insert(Comentario coment) {
        IComenRepo.save(coment);
    }

    @Override
    public Comentario listId(int id) {
        return IComenRepo.findById(id).orElse(new Comentario());
    }

    @Override
    public void update(Comentario coment) {
        IComenRepo.save(coment);
    }

    @Override
    public void delete(int id) {
        IComenRepo.deleteById(id);
    }
}
