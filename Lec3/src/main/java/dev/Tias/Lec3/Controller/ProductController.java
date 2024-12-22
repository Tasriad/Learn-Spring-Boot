package dev.Tias.Lec3.Controller;

import dev.Tias.Lec3.Model.Product;
import dev.Tias.Lec3.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController()
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    @GetMapping("/products/{id}")
    public Optional<Product> getProductbyId(@PathVariable int id) {
        return productService.getProductbyId(id);
    }
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
    //note-> we cant update product id
    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
