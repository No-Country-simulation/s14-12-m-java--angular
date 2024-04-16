package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String code;
    private Double percentage;
    private Boolean active;

    @OneToMany(mappedBy = "promotion")
    @JsonManagedReference
    private List<Product> products;

    //****** Helper Methods for Promotions: Keep Both Sides of the Association in SYNC.********/
    public void addProduct(Product product) {
        this.products.add(product);
        product.setPromotion(this);
    }

    public void removeProduct(Product product) {
        product.setPromotion(null);
        this.products.remove(product);
    }
}
