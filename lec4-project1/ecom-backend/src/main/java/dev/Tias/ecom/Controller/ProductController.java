package dev.Tias.ecom.Controller;

import dev.Tias.ecom.Model.Product;
import dev.Tias.ecom.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService service;
    @GetMapping("/products")
    public List<Product> getProducts()
    {
        return service.getProducts();
    }
    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable int id)
    {
        return service.getProductById(id);
    }
}
