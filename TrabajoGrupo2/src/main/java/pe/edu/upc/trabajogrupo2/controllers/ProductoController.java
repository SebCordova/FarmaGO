package pe.edu.upc.trabajogrupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajogrupo2.dtos.MarcaRegistradaDTO;
import pe.edu.upc.trabajogrupo2.dtos.ProductoDTO;
import pe.edu.upc.trabajogrupo2.dtos.RolDTO;
import pe.edu.upc.trabajogrupo2.entities.Producto;
import pe.edu.upc.trabajogrupo2.entities.Rol;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IProductoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService pS;

    @GetMapping
    public List<ProductoDTO> listar(){
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('DBotica') or hasAuthority('Administrador')")
    @PostMapping
    public void registrar(@RequestBody ProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        Producto pr = m.map(dto, Producto.class);
        pS.insert(pr);
    }

    @GetMapping("/{id}")
    public ProductoDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        ProductoDTO dto = m.map(pS.listId(id), ProductoDTO.class);

        return dto;
    }

    @PreAuthorize("hasAuthority('DBotica') or hasAuthority('Administrador')")
    @PutMapping
    public void modificar(@RequestBody ProductoDTO dto){
        ModelMapper m = new ModelMapper();
        Producto r = m.map(dto, Producto.class);
        pS.update(r);
    }

    @PreAuthorize("hasAuthority('DBotica') or hasAuthority('Administrador')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        pS.delete(id);
    }

    @PreAuthorize("hasAuthority('DBotica') or hasAuthority('Administrador')")
    @GetMapping("/marcasmasregistradas")
    public List<MarcaRegistradaDTO> listarMarcaMasRegistrada() {
        List<String[]> lista = pS.listarMarcaMasRegistrada();
        List<MarcaRegistradaDTO> listaDTO = new ArrayList<>();

        for (String[] x : lista) {
            MarcaRegistradaDTO dto = new MarcaRegistradaDTO();
            dto.setMarcaProducto(x[0]);
            dto.setTotalRegistros(Integer.parseInt(x[1]));
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
