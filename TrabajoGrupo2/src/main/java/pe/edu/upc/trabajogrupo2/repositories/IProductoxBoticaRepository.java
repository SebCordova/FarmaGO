package pe.edu.upc.trabajogrupo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajogrupo2.entities.ProductoxBotica;

@Repository
public interface IProductoxBoticaRepository extends JpaRepository<ProductoxBotica, Integer> {
}
