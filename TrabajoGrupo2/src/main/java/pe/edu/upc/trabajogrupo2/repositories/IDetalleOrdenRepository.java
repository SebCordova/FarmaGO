package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.DetalleOrden;

import java.util.List;

@Repository
public interface IDetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer> {

    @Query(value = "SELECT T1.id_botica,T1.id_producto,botica.nombre_botica,producto.nombre_producto FROM (\n" +
            " SELECT PXB.id_botica,PXB.id_producto,SUM(DETO.cantidad_producto)\n" +
            " FROM productox_botica PXB\n" +
            " INNER JOIN detalle_orden DETO \n" +
            " ON PXB.id_productox_botica = DETO.id_productox_botica\n" +
            " group by\n" +
            " PXB.id_botica,\n" +
            " PXB.id_producto) AS T1\n" +
            " INNER JOIN (\n" +
            " SELECT Tabla.id_botica,MAX(Tabla.sum) FROM\n" +
            " (SELECT PXB.id_botica,PXB.id_producto,SUM(DETO.cantidad_producto)\n" +
            " FROM productox_botica PXB\n" +
            " INNER JOIN detalle_orden DETO \n" +
            " ON PXB.id_productox_botica = DETO.id_productox_botica\n" +
            " group by\n" +
            " PXB.id_botica,\n" +
            " PXB.id_producto)AS Tabla\n" +
            " group by Tabla.id_botica) AS T2\n" +
            " \n" +
            " ON T1.id_botica=T2.id_botica\n" +
            " AND T1.sum=T2.max\n" +
            " INNER JOIN botica on T1.id_botica=botica.id_botica \n" +
            " INNER JOIN producto on T1.id_producto=producto.id_producto \n" +
            ";",nativeQuery = true)
    public List<String[]> ProductoVendidoxBotica();


    @Query(value = "SELECT PXB.id_botica,SUM(DETO.preciox_cantidad_producto),botica.nombre_botica AS Monto\n" +
            " FROM productox_botica PXB\n" +
            " INNER JOIN detalle_orden DETO \n" +
            " ON PXB.id_productox_botica = DETO.id_productox_botica\n" +
            "INNER JOIN botica on PXB.id_botica=botica.id_botica\n" +
            " group by\n" +
            " PXB.id_botica,\n" +
            " botica.nombre_botica\n"+
            " Order by\n" +
            " SUM(DETO.preciox_cantidad_producto) DESC\n" +
            " Limit 3;",nativeQuery = true)
    public List<String[]> BoticasConMayoresVentas();


}
