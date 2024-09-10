package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.UsuarioDTO;
import pe.edu.upc.trabajogrupo2.entities.Usuario;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("hasAuthority('Administrador')")
    @GetMapping
    public List<UsuarioDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('DBotica') or hasAuthority('Cliente')")
    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        String encodedPassword = passwordEncoder.encode(u.getClaveUsuario());
        u.setClaveUsuario(encodedPassword);
        uS.insert(u);
    }

    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.listId(id), UsuarioDTO.class);

        return dto;
    }

    @PreAuthorize("hasAuthority('Administrador')")
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.update(u);
    }

    @PreAuthorize("hasAuthority('Administrador')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        uS.delete(id);
    }
}
