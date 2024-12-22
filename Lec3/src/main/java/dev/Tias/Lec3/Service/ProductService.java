package dev.Tias.Lec3.Service;

import dev.Tias.Lec3.Model.Product;
import dev.Tias.Lec3.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductbyId(int id) {
        return productRepository.findById(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }
    public void updateProduct(Product product){
        //This will check if the product already exists in the database and if it does, it will update it
        productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
