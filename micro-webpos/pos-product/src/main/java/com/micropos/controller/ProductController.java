package com.micropos.controller;

import com.micropos.api.ProductsApi;
import com.micropos.model.Product;
import com.micropos.model.Quantity;
import com.micropos.pojo.SettingsWrapper;
import com.micropos.pojo.Category;
import com.micropos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:63342")
public class ProductController implements ProductsApi {

    private ProductService productService;

    @Autowired
    public void setPosService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<List<Product>> listProducts() {
        ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.allProducts(), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<Product> showProductById(String productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> updateProductQuantity(String productId, Quantity quantity) {
        return new ResponseEntity<>(productService.updateProductQuantity(productId, quantity.getQuantity()), HttpStatus.OK);
    }

    @GetMapping("/settings")
    public ResponseEntity<SettingsWrapper> getSettings() {
        return new ResponseEntity<>(productService.getSettings(), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(productService.getCategories(), HttpStatus.OK);
    }
}
