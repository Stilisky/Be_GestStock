package com.be.geststock.services;

import com.be.geststock.entities.Category;
import com.be.geststock.entities.Product;
import com.be.geststock.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository repository;

    public List<Category> allCategories(){
        return repository.findAll();
    }

    public Category catById(Long id){
        return repository.findById(id).get();
    }

    public Category saveCategory(Category category){
        return repository.save(category);
    }

    public void deleteCategory(Long id){
        repository.deleteById(id);
    }

    public Category updateCategory(Long id, Category category){
        Category oldCategory = repository.findById(id).get();
        if (! oldCategory.getCatName().equals(category.getCatName())){
            oldCategory.setCatName(category.getCatName());
        }
        return oldCategory;
    }

    public List<Product> findProductsOfCategory(Long id){
        return repository.findById(id).get().getProducts();
    }


    public Category findCategoryById(Long id) {
        return repository.findById(id).get();
    }
}
