package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.OrdenCompraDTO;
import pe.edu.upc.trabajogrupo2.entities.OrdenCompra;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IOrdenCompraService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordenescompras")
public class OrdenCompraController {
    @Autowired
    private IOrdenCompraService oS;

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('Cliente')")
    @GetMapping
    public List<OrdenCompraDTO> listar(){
        return oS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, OrdenCompraDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody OrdenCompraDTO dto) {
        ModelMapper m = new ModelMapper();
        OrdenCompra oc = m.map(dto, OrdenCompra.class);
        oS.insert(oc);
    }

    @GetMapping("/{id}")
    public OrdenCompraDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        OrdenCompraDTO dto = m.map(oS.listId(id), OrdenCompraDTO.class);

        return dto;
    }

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('Cliente')")
    @PutMapping
    public void modificar(@RequestBody OrdenCompraDTO dto){
        ModelMapper m = new ModelMapper();
        OrdenCompra oc = m.map(dto, OrdenCompra.class);
        oS.update(oc);
    }

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('Cliente')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        oS.delete(id);
    }
}
