package sk.stuba.fei.uim.oop.assignment3.cart.web;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;

import java.util.List;

@Getter
@Setter
public class CartRequest {
    private Long id;
    private List<CartItem> shoppingList;
    private boolean payed;
}