package sk.stuba.fei.uim.oop.assignment3.cart.web;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;

import java.util.List;

@Getter
public class CartResponse {
    private final Long id;
    private final List<CartItem> shoppingList;
    private final boolean payed;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.shoppingList = cart.getShoppingList();
        this.payed = cart.isPayed();
    }
}
