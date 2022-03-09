package com.example.poshell.db;

import com.example.poshell.model.Cart;
import com.example.poshell.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PosInMemoryDB implements PosDB {
    public boolean cart_flag = false ;
    private List<Product> products = new ArrayList<>();

    private Cart cart;

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Cart saveCart(Cart cart) {
        this.cart = cart;
        cart_flag = true;
        return this.cart;
    }

    @Override
    public void checkout() {
        if(cart_flag){
            System.out.println("Cart Ready");
        }
        else{
            System.out.println("No Cart");
        }
    }

    @Override
    public Cart getCart() {
        return this.cart;
    }

    @Override
    public Product getProduct(String productId) {
        for (Product p : getProducts()) {
            if (p.getId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    private PosInMemoryDB() {
        this.products.add(new Product("PD1", "iPhone 13", 8999));
        this.products.add(new Product("PD2", "MacBook Pro", 29499));
    }

}
