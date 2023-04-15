package com.be.geststock.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "categoryId")
    private Long catId;

    @Column(name = "categoryName")
    private String catName;


    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
