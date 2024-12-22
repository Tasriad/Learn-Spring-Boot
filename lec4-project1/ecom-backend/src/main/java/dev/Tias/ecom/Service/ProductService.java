package dev.Tias.ecom.Service;

import dev.Tias.ecom.Model.Product;
import dev.Tias.ecom.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo repository;
    public List<Product> getProducts() {
        return repository.findAll();
    }
    public Optional<Product> getProductById(int id) {
        return repository.findById(id);
    }
}
