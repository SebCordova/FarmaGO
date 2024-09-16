package pe.edu.upc.trabajogrupo2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.trabajogrupo2.dtos.ProductoVencidoDTO;
import pe.edu.upc.trabajogrupo2.serviceinterfaces.IProductoxBoticaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productoxbotica")
public class ProductoxBoticaController {
    @Autowired
    private IProductoxBoticaService bpS;

    @PreAuthorize("hasAuthority('Administrador') or hasAuthority('DBotica')")
    @GetMapping("/productosvencidos")
    public List<ProductoVencidoDTO> listarProductosVencidos(@RequestParam int idBotica){
        List<String[]> lista = bpS.productosVencidosPorBotica(idBotica);
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
}
