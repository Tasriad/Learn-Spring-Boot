package dev.Tias.Lec2.Service;

import dev.Tias.Lec2.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Product 1", 100.0),
            new Product(2, "Product 2", 200.0),
            new Product(3, "Product 3", 300.0),
            new Product(4, "Product 4", 400.0),
            new Product(5, "Product 5", 500.0)
    ));


    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> getProductbyId(int id) {
        return Optional.of(products.stream().filter(product -> product.getId() == id).findFirst().get());
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    public void updateProduct(Product product){
        Product currentProduct = products.stream()
                .filter(p->p.getId()==product.getId())
                .findFirst()
                .get();
        currentProduct.setId(product.getId());
        currentProduct.setName(product.getName());
        currentProduct.setPrice(product.getPrice());
    }

    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
