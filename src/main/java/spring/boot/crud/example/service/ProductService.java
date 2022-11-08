package spring.boot.crud.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.crud.example.entity.Product;
import spring.boot.crud.example.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    // post
    public Product saveProduct (Product product){
        return repository.save(product);
    }
    public List<Product> saveProducts (List<Product> products){
        return repository.saveAll(products);
    }

    //get
    public List<Product> getProducts (){
        return repository.findAll();
    }
    public Product getProductById (int id){
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName (String name){
        return repository.findByName(name);
    }

    //delete
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed !!"+id;
    }

    //put
    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }



}
