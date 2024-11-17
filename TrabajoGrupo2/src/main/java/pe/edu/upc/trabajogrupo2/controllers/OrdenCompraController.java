package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.OrdenCompraDTO;
import pe.edu.upc.trabajogrupo2.dtos.UsuarioOrdenesDTO;
import pe.edu.upc.trabajogrupo2.entities.OrdenCompra;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IOrdenCompraService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordenescompras")
public class OrdenCompraController {
    @Autowired
    private IOrdenCompraService oS;

    @PreAuthorize("hasAuthority('Cliente') or hasAuthority('Administrador')")
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

    @PreAuthorize("hasAuthority('Cliente') or hasAuthority('Administrador')")
    @PutMapping
    public void modificar(@RequestBody OrdenCompraDTO dto){
        ModelMapper m = new ModelMapper();
        OrdenCompra oc = m.map(dto, OrdenCompra.class);
        oS.update(oc);
    }

    @PreAuthorize("hasAuthority('Cliente') or hasAuthority('Administrador')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        oS.delete(id);
    }

    @GetMapping("/busquedaOrdenCompra")
    public List<OrdenCompraDTO> buscar(@RequestParam String nombre){
        return oS.buscar(nombre).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, OrdenCompraDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('DBotica') or hasAuthority('Administrador')")
    @GetMapping("/usuariosconmayoresordenes")
    public List<UsuarioOrdenesDTO> UsuariosConMasOrdenesController() {

        List<String[]> lista = oS.listarUsuariosConMasOrdenes();
        List<UsuarioOrdenesDTO> listaDTO = new ArrayList<>();

        for (String[] x : lista) {
            UsuarioOrdenesDTO dto = new UsuarioOrdenesDTO();
            dto.setIdUsuario(Integer.parseInt(x[0]));
            dto.setNomUsuario(x[1]);
            dto.setTotalOrdenes(Integer.parseInt(x[2]));
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
