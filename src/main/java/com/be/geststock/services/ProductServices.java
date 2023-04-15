package com.be.geststock.services;

import com.be.geststock.entities.Product;
import com.be.geststock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository repository;

    public List<Product> allProducts(){
        return repository.findAll();
    }
    public Product findProdById(Long id){
        return repository.findById(id).get();
    }

    public Product saveProd(Product product){
        return repository.save(product);
    }

    public void deletePRod(Long id){
        repository.deleteById(id);
    }

    public Product updateProd(Long id, Product product){
        Product oldProd = repository.findById(id).get();
        if (!oldProd.getNameProd().equals(product.getNameProd())){
            oldProd.setNameProd(product.getNameProd());
        }
        if (!oldProd.getDescProd().equals(product.getDescProd())){
            oldProd.setDescProd(product.getDescProd());
        }
        if (oldProd.getPriceProd() != product.getPriceProd()){
            oldProd.setPriceProd(product.getPriceProd());
        }
        if (oldProd.getQtyProd() != product.getQtyProd()){
            oldProd.setQtyProd(product.getQtyProd());
        }

        return oldProd;
    }

}
