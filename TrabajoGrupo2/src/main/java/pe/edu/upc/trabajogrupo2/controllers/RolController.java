package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.RolDTO;
import pe.edu.upc.trabajogrupo2.entities.Rol;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rS;

    @PreAuthorize("hasAuthority('Administrador')")
    @GetMapping
    public List<RolDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('Administrador')")
    @PostMapping
    public void registrar(@RequestBody RolDTO dto){
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rS.insert(r);
    }

    @GetMapping("/{id}")
    public RolDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rS.listId(id), RolDTO.class);

        return dto;
    }

    @PreAuthorize("hasAuthority('Administrador')")
    @PutMapping
    public void modificar(@RequestBody RolDTO dto){
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rS.update(r);
    }

    @PreAuthorize("hasAuthority('Administrador')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        rS.delete(id);
    }

}
