package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.*;
import pe.edu.upc.trabajogrupo2.entities.Botica;
import pe.edu.upc.trabajogrupo2.entities.DetalleOrden;
import pe.edu.upc.trabajogrupo2.entities.Producto;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IDetalleOrdenService;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IProductoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detalleOrden")
public class DetalleOrdenController {

    @Autowired
    private IDetalleOrdenService IDS;

    @PreAuthorize("hasAuthority('Cliente') or hasAuthority('Administrador')")
    @GetMapping
    public List<DetalleOrdenDTO> listar(){
        return IDS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DetalleOrdenDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('Cliente') or hasAuthority('Administrador')")
    @PostMapping
    public void registrar(@RequestBody DetalleOrdenDTO dto) {
        ModelMapper m = new ModelMapper();
        DetalleOrden deto = m.map(dto, DetalleOrden.class);
        IDS.insert(deto);
    }

    @PreAuthorize("hasAuthority('Cliente') or hasAuthority('Administrador')")
    @GetMapping("/{id}")
    public DetalleOrdenDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        DetalleOrdenDTO dto = m.map(IDS.listId(id), DetalleOrdenDTO.class);

        return dto;
    }

    @PreAuthorize("hasAuthority('Cliente') or hasAuthority('Administrador')")
    @PutMapping
    public void modificar(@RequestBody DetalleOrdenDTO dto){
        ModelMapper m = new ModelMapper();
        DetalleOrden r = m.map(dto, DetalleOrden.class);
        IDS.update(r);
    }

    @PreAuthorize("hasAuthority('Cliente') or hasAuthority('Administrador')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        IDS.delete(id);
    }


    @PreAuthorize("hasAuthority('Cliente') or hasAuthority('Administrador')")
    @GetMapping("/productovendidoxbotica")
    public List<ProductoVendidoxBoticaDTO> ProductoVendidoxBoticaController(){

        //obtiene al información de la tabla y lo inserta en el objeto Lista de tipo string "lista"
        List<String[]> lista= IDS.ProductoVendidoxBotica();
        //crea un objeto lista de tipo DTO creado
        List<ProductoVendidoxBoticaDTO> listaDTO= new ArrayList<>();

        /*Debemos colocar toda la info metida en lista que es un objeto string usado en el Service, dentro de lista DTO
        que es el que acepta este metodo del Controller.
        */
        for(String[] x:lista){
            ProductoVendidoxBoticaDTO dto= new ProductoVendidoxBoticaDTO();
            dto.setBotica(Integer.parseInt(x[0]));
            dto.setProductoVendido(Integer.parseInt(x[1]));
            dto.setNombreB((x[2]));
            dto.setNombreP(((x[3])));
            listaDTO.add(dto);

        }
        return listaDTO;

    }



    @PreAuthorize("hasAuthority('Cliente') or hasAuthority('Administrador')")
    @GetMapping("/boticasconmayoresventas")
    public List<BoticaConMayoresVentasDTO> BoticaConMayoresVentasController(){

        //obtiene al información de la tabla y lo inserta en el objeto Lista de tipo string "lista"
        List<String[]> lista= IDS.BoticasConMayoresVentas();
        //crea un objeto lista de tipo DTO creado
        List<BoticaConMayoresVentasDTO> listaDTO= new ArrayList<>();

        /*Debemos colocar toda la info metida en lista que es un objeto string usado en el Service, dentro de lista DTO
        que es el que acepta este metodo del Controller.
        */
        for(String[] x:lista){
            BoticaConMayoresVentasDTO dto= new BoticaConMayoresVentasDTO();
            dto.setIdBotica(Integer.parseInt(x[0]));
            dto.setMonto((Double.parseDouble(x[1])));
            dto.setNombreBotica((x[2]));
            listaDTO.add(dto);

        }
        return listaDTO;
    }
}
