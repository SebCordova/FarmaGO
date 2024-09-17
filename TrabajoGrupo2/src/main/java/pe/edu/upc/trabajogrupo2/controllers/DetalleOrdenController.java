package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.DetalleOrdenDTO;
import pe.edu.upc.trabajogrupo2.dtos.ProductoDTO;
import pe.edu.upc.trabajogrupo2.entities.DetalleOrden;
import pe.edu.upc.trabajogrupo2.entities.Producto;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IDetalleOrdenService;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IProductoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detalleOrden")
public class DetalleOrdenController {

    @Autowired
    private IDetalleOrdenService IDS;

    @GetMapping
    public List<DetalleOrdenDTO> listar(){
        return IDS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DetalleOrdenDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('DBotica')")
    @PostMapping
    public void registrar(@RequestBody DetalleOrdenDTO dto) {
        ModelMapper m = new ModelMapper();
        DetalleOrden deto = m.map(dto, DetalleOrden.class);
        IDS.insert(deto);
    }

    @GetMapping("/{id}")
    public DetalleOrdenDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        DetalleOrdenDTO dto = m.map(IDS.listId(id), DetalleOrdenDTO.class);

        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody DetalleOrdenDTO dto){
        ModelMapper m = new ModelMapper();
        DetalleOrden r = m.map(dto, DetalleOrden.class);
        IDS.update(r);
    }

    @PreAuthorize("hasAuthority('DBotica') or hasAuthority('Administrador')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        IDS.delete(id);
    }
}
