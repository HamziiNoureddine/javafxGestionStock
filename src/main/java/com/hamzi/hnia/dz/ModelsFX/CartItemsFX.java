package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Models.Produit;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;


public class CartItemsFX {
    private Produit produit;
    private IntegerProperty quantite = new SimpleIntegerProperty();
    private ObjectProperty<BigDecimal> prix = new SimpleObjectProperty<>();
    private  ObjectProperty<BigDecimal> total = new SimpleObjectProperty<>();

    public CartItemsFX(Produit produit,Integer quantite,BigDecimal prix){
        this.produit = produit;
        this.quantite.set(quantite);
        this.prix.set(prix);
        total.bind(
                Bindings.createObjectBinding(
                        () -> this.prix.get().multiply(BigDecimal.valueOf(this.quantite.get())),
                        this.prix,
                        this.quantite
                )
        );
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite.get();
    }

    public IntegerProperty quantiteProperty() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite.set(quantite);
    }

    public BigDecimal getPrix() {
        return prix.get();
    }

    public ObjectProperty prixProperty() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix.set(prix);
    }

    public BigDecimal getTotal() {
        return total.get();
    }

    public ObjectProperty totalProperty() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total.set(total);
    }
}
