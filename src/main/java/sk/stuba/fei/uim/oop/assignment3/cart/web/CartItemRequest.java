package sk.stuba.fei.uim.oop.assignment3.cart.web;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;


@Getter
@Setter
public class CartItemRequest {
    private Long productId;
    private int amount;

    public CartItemRequest(Long productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public CartItemRequest(CartItem cartItem) {
        this.productId = cartItem.getProduct().getId();
        this.amount = cartItem.getAmount();
    }
}