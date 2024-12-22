package dev.Tias.Lec3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.Tias.Lec3.Model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
