package sk.stuba.fei.uim.oop.assignment3.cart.web;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;

import java.util.List;

@Getter
public class CartResponse {
    private final Long id;
    private final List<CartItemRequest> shoppingList;
    private final boolean payed;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.shoppingList = cart.getShoppingList().stream().map(CartItemRequest::new).collect(java.util.stream.Collectors.toList());
        this.payed = cart.isPayed();
    }
}
