package pe.edu.upc.trabajogrupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Comentario;
import pe.edu.upc.trabajogrupo2.entities.ProductoxBotica;
import pe.edu.upc.trabajogrupo2.repositories.IProductoxBoticaRepository;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IProductoxBoticaService;

import java.util.List;

@Service
public class ProductoxBoticaServiceImplement implements IProductoxBoticaService {
    @Autowired
    private IProductoxBoticaRepository IprodxBotRepo;

    @Override
    public List<ProductoxBotica> list() {
        return IprodxBotRepo.findAll();
    }

    @Override
    public void insert(ProductoxBotica ProdxBot) {
        IprodxBotRepo.save(ProdxBot);
    }

    @Override
    public ProductoxBotica listId(int id) {
        return IprodxBotRepo.findById(id).orElse(new ProductoxBotica());
    }

    @Override
    public void update(ProductoxBotica ProdxBot) {
        IprodxBotRepo.save(ProdxBot);
    }

    @Override
    public void delete(int id) {
        IprodxBotRepo.deleteById(id);
    }
}
