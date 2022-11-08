package spring.boot.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.crud.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
