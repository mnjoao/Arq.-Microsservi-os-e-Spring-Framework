package com.example.produtos.service;

import java.util.List;
import java.util.ArrayList;
import com.example.produtos.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Long id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId().equals(id)) {
                products.set(i, updatedProduct);
                return;
            }
        }
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}