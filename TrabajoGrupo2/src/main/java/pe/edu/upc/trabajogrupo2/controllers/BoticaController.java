package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.BoticaConMayoresVentasDTO;
import pe.edu.upc.trabajogrupo2.dtos.BoticaDTO;
import pe.edu.upc.trabajogrupo2.dtos.DistritoConMayorBoticasDTO;
import pe.edu.upc.trabajogrupo2.entities.Botica;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IBoticaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/boticas")
public class BoticaController {

    @Autowired
    private IBoticaService bS;

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('DBotica')")
    @GetMapping
    public List<BoticaDTO> listar(){
        return bS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,BoticaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('DBotica')")
    @PostMapping
    public void registrar(@RequestBody BoticaDTO dto){
        ModelMapper m = new ModelMapper();
        Botica b = m.map(dto, Botica.class);
        bS.insert(b);
    }

    @GetMapping("/{id}")
    public BoticaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        BoticaDTO dto = m.map(bS.listId(id), BoticaDTO.class);

        return dto;
    }

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('DBotica')")
    @PutMapping
    public void modificar(@RequestBody BoticaDTO dto){
        ModelMapper m = new ModelMapper();
        Botica b = m.map(dto, Botica.class);
        bS.update(b);
    }

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('DBotica')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        bS.delete(id);
    }


    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('DBotica')")
    @GetMapping("/buscarporDistrito")
    public List<BoticaDTO> listarBoticasPorDistrito(@RequestParam int idDistrito) {
        return bS.listarBoticasDistrito(idDistrito).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,BoticaDTO.class);
        }).collect(Collectors.toList());
    }

    /*
    @PreAuthorize("hasAuthority('Administrador')")
    @GetMapping("/buscardistritocantboticas")
    public List<DistritoConMayorBoticasDTO> listarDistritoMayorCantBoticas() {
        return bS.listarDistritoMayorCantBoticas().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,DistritoConMayorBoticasDTO.class);
        }).collect(Collectors.toList());
    }*/

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('DBotica')")
    @GetMapping("/buscardistritocantboticas")
    public List<DistritoConMayorBoticasDTO> listarDistritoMayorCantBoticas() {
        List<String[]> lista= bS.listarDistritoMayorCantBoticas();

        List<DistritoConMayorBoticasDTO> listaDTO= new ArrayList<>();

        for(String[] x:lista){
            DistritoConMayorBoticasDTO dto= new DistritoConMayorBoticasDTO();
            dto.setDistrito((x[0]));
            dto.setCantidad((Integer.parseInt(x[1])));
            listaDTO.add(dto);

        }
        return listaDTO;
    }
}
