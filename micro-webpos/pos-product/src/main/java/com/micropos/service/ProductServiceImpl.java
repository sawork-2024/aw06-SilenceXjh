package com.micropos.service;

import com.micropos.db.ProductRepository;
import com.micropos.model.Product;
import com.micropos.pojo.Category;
import com.micropos.pojo.SettingsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> allProducts() {
        return productRepository.getProducts();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Product updateProductQuantity(String id, int quantity) {
        return productRepository.updateProductQuantity(id, quantity);
    }


    @Override
    public SettingsWrapper getSettings() {
        return productRepository.getSettings();
    }

    @Override
    public List<Category> getCategories() {
        return productRepository.getCategories();
    }
}
