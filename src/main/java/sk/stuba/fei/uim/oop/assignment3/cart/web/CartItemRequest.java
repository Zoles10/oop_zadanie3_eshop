package sk.stuba.fei.uim.oop.assignment3.cart.web;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CartItemRequest {
    private Long productId;
    private int amount;

    public CartItemRequest(Long productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }
}