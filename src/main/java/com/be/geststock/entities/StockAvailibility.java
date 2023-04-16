package com.be.geststock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StockAvailibility {

    private double qty;
    private String details;

    public StockAvailibility(double qty, String details){
        this.qty = qty;
        if(qty <= 5){
            details = "Rupture de stock";
        }
        else if (qty >5 && qty <= 25){
            details = "Veuillez prévoir le réapprovisionnemment de ce produit!";
        }
        else {
            details = "Stock Suffisant";
        }
        this.details = details;
    }
    
}
