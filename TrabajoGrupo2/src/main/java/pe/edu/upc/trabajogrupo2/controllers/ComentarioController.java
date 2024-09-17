package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.ComentarioDTO;
import pe.edu.upc.trabajogrupo2.entities.Comentario;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IComentarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private IComentarioService cS;

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('Cliente')")
    @GetMapping
    public List<ComentarioDTO> listar(){
        return cS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ComentarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('Cliente')")
    @PostMapping
    public void registrar(@RequestBody ComentarioDTO dto){
        ModelMapper m = new ModelMapper();
        Comentario b = m.map(dto, Comentario.class);
        cS.insert(b);
    }

    @GetMapping("/{id}")
    public ComentarioDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        ComentarioDTO dto = m.map(cS.listId(id), ComentarioDTO.class);

        return dto;
    }

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('Cliente')")
    @PutMapping
    public void modificar(@RequestBody ComentarioDTO dto){
        ModelMapper m = new ModelMapper();
        Comentario b = m.map(dto, Comentario.class);
        cS.update(b);
    }

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('Cliente')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }
}
