package pe.edu.upc.trabajogrupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Comentario;
import pe.edu.upc.trabajogrupo2.entities.DetalleOrden;
import pe.edu.upc.trabajogrupo2.repositories.IDetalleOrdenRepository;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IDetalleOrdenService;

import java.util.List;

@Service
public class DetalleOrdenServiceImplement implements IDetalleOrdenService {
    @Autowired
    private IDetalleOrdenRepository IdetOrdRepo;

    @Override
    public List<DetalleOrden> list() {
        return IdetOrdRepo.findAll();
    }

    @Override
    public void insert(DetalleOrden DetOrd) {
        IdetOrdRepo.save(DetOrd);
    }

    @Override
    public DetalleOrden listId(int id) {
        return IdetOrdRepo.findById(id).orElse(new DetalleOrden());
    }

    @Override
    public void update(DetalleOrden DetOrd) {
    IdetOrdRepo.save(DetOrd);
    }

    @Override
    public void delete(int id) {
        IdetOrdRepo.deleteById(id);
    }
}
