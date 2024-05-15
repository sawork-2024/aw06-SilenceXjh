package com.micropos.service;

import com.micropos.model.Product;
import com.micropos.pojo.Category;
import com.micropos.pojo.SettingsWrapper;

import java.util.List;

public interface ProductService {

    public List<Product> allProducts();

    public Product getProductById(String id);

    public Product updateProductQuantity(String id, int quantity);

    public SettingsWrapper getSettings();

    public List<Category> getCategories();
}
