package com.be.geststock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Long prodId;

    @Column(name = "productname")
    private String nameProd;

    @Column(name = "productdescription")
    private String descProd;

    @Column(name = "productprice")
    private double priceProd;

    @Column(name = "productqty")
    private double qtyProd;

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "categoryid")
    private Category category;
}
