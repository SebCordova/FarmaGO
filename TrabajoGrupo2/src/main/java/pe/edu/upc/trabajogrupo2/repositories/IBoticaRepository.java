package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Botica;

import java.util.List;

@Repository
public interface IBoticaRepository extends JpaRepository<Botica, Integer> {
    @Query(value = "SELECT * FROM botica b WHERE b.id_distrito = :idDistrito;", nativeQuery = true)
    public List<Botica> listarBoticasPorDistrito(@Param("idDistrito") int idDistrito);

    @Query(value = "SELECT d.nom_distrito, count(b.nombre_botica) as cant_boticas\n" +
            " FROM botica b\n" +
            " JOIN distrito d ON b.id_distrito = d.id_distrito\n" +
            " GROUP BY d.nom_distrito\n" +
            " ORDER BY cant_boticas DESC;", nativeQuery = true)
    public List<String[]> listarDistritoMayorCantBoticas();
}
