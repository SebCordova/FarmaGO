package pe.edu.upc.trabajogrupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Botica;
import pe.edu.upc.trabajogrupo2.repositories.IBoticaRepository;
import pe.edu.upc.trabajogrupo2.repositories.IDistritoRepository;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IBoticaService;

import java.util.List;

@Service
public class BoticaServiceImplement implements IBoticaService {

    @Autowired
    private IBoticaRepository bR;

    @Override
    public List<Botica> list() {
        return bR.findAll();
    }

    @Override
    public void insert(Botica botica) {
        bR.save(botica);
    }

    @Override
    public Botica listId(int id) {
        return bR.findById(id).orElse(new Botica());
    }

    @Override
    public void update(Botica botica) {
        bR.save(botica);
    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);
    }

    @Override
    public List<Botica> listarBoticasDistrito(int idDistrito) {
        return bR.listarBoticasPorDistrito(idDistrito);
    }

    @Override
    public List<String[]> listarDistritoMayorCantBoticas() {
        return bR.listarDistritoMayorCantBoticas();
    }
}
