package com.hamzi.hnia.dz.Services.Cart;

import com.hamzi.hnia.dz.Models.Produit;
import com.hamzi.hnia.dz.ModelsFX.CartItemsFX;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


public interface CarteService {
    public  void ajoutProduit(Produit produit, int quantite, BigDecimal prix);
    public  void supprimeProduit(Long productId);
    public void initCart();
    List<CartItemsFX> getCart();
    public double getTotal();
}
