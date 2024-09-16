package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.ProductoxBotica;

import java.util.List;

@Repository
public interface IProductoxBoticaRepository extends JpaRepository<ProductoxBotica, Integer> {
    @Query(value = "SELECT b.id_productox_botica, p.nombre_producto, b.fechavencimiento\n" +
            " FROM productox_botica b\n" +
            " JOIN producto p ON b.id_producto = p.id_producto\n" +
            " WHERE b.id_botica = :idBotica\n" +
            " GROUP BY b.id_productox_botica, p.nombre_producto, b.fechavencimiento;", nativeQuery = true)
    public List<String[]> listarProductosVencidos(@Param("idBotica") int idBotica);
}
