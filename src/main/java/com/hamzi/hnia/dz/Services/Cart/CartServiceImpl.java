package com.hamzi.hnia.dz.Services.Cart;

import com.hamzi.hnia.dz.Models.Produit;
import com.hamzi.hnia.dz.ModelsFX.CartItemsFX;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CarteService{
    private List<CartItemsFX> cart = new ArrayList<>();
    @Override
    public void ajoutProduit(Produit produit, int quantite, BigDecimal prix) {
        for (CartItemsFX cartItems : cart){
            if(cartItems.getProduit().getId().equals(produit.getId())){
                cartItems.setQuantite(cartItems.getQuantite()+1);
                return;
            }

        }
     cart.add(new CartItemsFX(produit,quantite,prix));
    }

    @Override
    public void supprimeProduit(Long productId) {
     cart.removeIf(item-> item.getProduit().getId().equals(productId));
    }

    @Override
    public void initCart() {
      cart.clear();
    }

    @Override
    public List<CartItemsFX> getCart() {
        return cart;
    }

    @Override
    public double getTotal() {
        return cart.stream()
                .mapToDouble(i-> i.getPrix().doubleValue() * i.getQuantite()).sum();
    }
}
