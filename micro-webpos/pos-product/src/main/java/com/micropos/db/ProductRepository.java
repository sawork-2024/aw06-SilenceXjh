package com.micropos.db;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.micropos.model.Product;
import com.micropos.pojo.Category;
import com.micropos.pojo.SettingsWrapper;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;
    private SettingsWrapper settingsWrapper;
    private List<Category> categories;

    public ProductRepository() {
        loadDataFromJsonFile();
    }

    private void loadDataFromJsonFile() {
        ObjectMapper mapper = new ObjectMapper();

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("products.json");
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader)) {
            products = mapper.readValue(reader, new TypeReference<List<Product>>() {});
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("settings.json");
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader)) {
            settingsWrapper = mapper.readValue(reader, SettingsWrapper.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("categories.json");
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader)) {
            categories = mapper.readValue(reader, new TypeReference<List<Category>>() {});
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(String id) {
        for (Product product : products) {
            if(product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public Product updateProductQuantity(String id, int quantity) {
        for (Product product : products) {
            if(product.getId().equals(id)) {
                product.setQuantity(quantity);
                return product;
            }
        }
        return null;
    }

    public SettingsWrapper getSettings() {
        return settingsWrapper;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
