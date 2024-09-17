package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.DetalleOrdenDTO;
import pe.edu.upc.trabajogrupo2.dtos.ProductoxBoticaDTO;
import pe.edu.upc.trabajogrupo2.entities.DetalleOrden;
import pe.edu.upc.trabajogrupo2.entities.ProductoxBotica;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IDetalleOrdenService;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IProductoxBoticaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productoxBotica")
public class ProductoxBoticaController {


    @Autowired
    private IProductoxBoticaService IxBServ;

    @GetMapping
    public List<ProductoxBoticaDTO> listar(){
        return IxBServ.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductoxBoticaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('DBotica')")
    @PostMapping
    public void registrar(@RequestBody ProductoxBoticaDTO dto) {
        ModelMapper m = new ModelMapper();
        ProductoxBotica pxb = m.map(dto, ProductoxBotica.class);
        IxBServ.insert(pxb);
    }

    @GetMapping("/{id}")
    public ProductoxBoticaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        ProductoxBoticaDTO dto = m.map(IxBServ.listId(id), ProductoxBoticaDTO.class);

        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody ProductoxBoticaDTO dto){
        ModelMapper m = new ModelMapper();
        ProductoxBotica r = m.map(dto, ProductoxBotica.class);
        IxBServ.update(r);
    }

    @PreAuthorize("hasAuthority('DBotica') or hasAuthority('Administrador')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        IxBServ.delete(id);
    }
}
