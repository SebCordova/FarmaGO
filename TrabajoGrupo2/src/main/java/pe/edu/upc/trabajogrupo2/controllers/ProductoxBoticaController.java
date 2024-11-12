package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.DetalleOrdenDTO;
import pe.edu.upc.trabajogrupo2.dtos.ProductoVencidoDTO;
import pe.edu.upc.trabajogrupo2.dtos.ProductoxBoticaDTO;
import pe.edu.upc.trabajogrupo2.entities.DetalleOrden;
import pe.edu.upc.trabajogrupo2.entities.ProductoxBotica;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IDetalleOrdenService;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IProductoxBoticaService;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @PreAuthorize("hasAuthority('DBotica') or hasAuthority('Administrador')")
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

    @PreAuthorize("hasAuthority('DBotica') or hasAuthority('Administrador')")
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

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('DBotica')")
    @GetMapping("/productosvencidos")
    public List<ProductoVencidoDTO> listarProductosVencidos(@RequestParam int idBotica){
        List<String[]> lista = IxBServ.productosVencidosPorBotica(idBotica);
        List<ProductoVencidoDTO> listaDTO = new ArrayList<>();
        for (String[]columna: lista){
            ProductoVencidoDTO dto =new ProductoVencidoDTO();
            dto.setIdProductoxBotica(Integer.parseInt(columna[0]));
            dto.setNombreProducto(columna[1]);
            dto.setFechaVencimiento(LocalDate.parse(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/productosXprecio")
    public List<ProductoxBoticaDTO> listarProductosPorPrecio() {
        return IxBServ.listarProductosPorPrecio().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductoxBoticaDTO.class);
        }).collect(Collectors.toList());
    }
}
