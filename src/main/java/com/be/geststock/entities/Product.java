package com.be.geststock.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "productId")
    private Long prodId;

    @Column(name = "productName")
    private String nameProd;

    @Column(name = "productDescription")
    private String descProd;

    @Column(name = "productPrice")
    private double priceProd;

    @Column(name = "productQty")
    private double qtyProd;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "categoryId")
    private Category category;
}
