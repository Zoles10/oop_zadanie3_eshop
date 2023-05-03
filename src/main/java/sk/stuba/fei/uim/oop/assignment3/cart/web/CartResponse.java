package sk.stuba.fei.uim.oop.assignment3.cart.web;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import java.util.List;

@Getter
public class CartResponse {
    private final Long id;
    private final List<Product> shoppingCart;
    private final boolean paid;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.shoppingCart = cart.getShoppingCart();
        this.paid = cart.isPaid();
    }
}
