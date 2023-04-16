package com.be.geststock.controllers;

import com.be.geststock.entities.Category;
import com.be.geststock.entities.Product;
import com.be.geststock.entities.StockAvailibility;
import com.be.geststock.services.CategoryServices;
import com.be.geststock.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GestStockRestController {

    @Autowired
    private ProductServices productServices;
    @Autowired
    private CategoryServices categoryServices;

    @GetMapping(value = "/products")
    public List<Product> allProducts(){
        return productServices.allProducts();
    }

    @GetMapping(value = "/categories")
    public List<Category> allCategories(){
        return categoryServices.allCategories();
    }

    @GetMapping(value = "/products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productServices.findProdById(id);
    }

    @GetMapping(value = "/categories/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryServices.findCategoryById(id);
    }

    @GetMapping(value = "/products/category/{id}")
    public List<Product> getProductsByCategory(@PathVariable Long id){
        return categoryServices.findProductsOfCategory(id);
    }

    @PostMapping(value = "/products")
    public Product addProduct(@RequestBody Product product){
        return productServices.saveProd(product);
    }

    @PostMapping(value = "/category")
    public Category addCategory(@RequestBody Category category){
        return categoryServices.saveCategory(category);
    }

    @PutMapping(value = "/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productServices.updateProd(id, product);
    }

    @PutMapping(value = "/category/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category){
        return categoryServices.updateCategory(id, category);
    }

    @DeleteMapping(value = "/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productServices.deletePRod(id);
    }

    @DeleteMapping(value = "/category/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryServices.deleteCategory(id);
    }

    @GetMapping(value = "products/{id}/stock")
    public StockAvailibility etatStock(@PathVariable Long id){
        Product product = productServices.findProdById(id);
        return new StockAvailibility(product.getQtyProd(), null);
    }

    

}
