package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.Comentario;

import java.util.List;
import java.util.Vector;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer>{

    @Query(value="SELECT com.id_usuario, u.nom_usuario, COUNT(com) as totalComentarios \n" +
            "            FROM Comentario com\n "+
            "            INNER JOIN Usuario u ON com.id_usuario=u.id_usuario\n" +
            "            GROUP BY com.id_usuario,u.nom_usuario\n" +
            "            ORDER BY totalComentarios DESC", nativeQuery = true)
    public List<String[]> listarUsuariosConMasComentarios();

    @Query("SELECT c FROM Comentario c WHERE c.PxBotica.idProductoxBotica = :idProductoxBotica")
    List<Comentario> findByPxBoticaId(@Param("idProductoxBotica") int idProductoxBotica);
}
