package com.adesh.Productapi.service;

import com.adesh.Productapi.entity.Item;
import com.adesh.Productapi.entity.Product;
import com.adesh.Productapi.repository.ItemRepository;
import com.adesh.Productapi.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;

    public ProductService(
            ProductRepository productRepository,
            ItemRepository itemRepository) {
        this.productRepository = productRepository;
        this.itemRepository = itemRepository;
    }

    public Page<Product> getAllProducts(Pageable pageable) {

        return productRepository.findAll(pageable);
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        product.setCreatedOn(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        product.setProductName(productDetails.getProductName());
        product.setModifiedBy(productDetails.getModifiedBy());
        product.setModifiedOn(LocalDateTime.now());

        return productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }

        productRepository.deleteById(id);
    }

    public List<Item> getProductItems(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        return itemRepository.findAll()
                .stream()
                .filter(item ->
                        item.getProduct().getId().equals(product.getId()))
                .toList();
    }
}