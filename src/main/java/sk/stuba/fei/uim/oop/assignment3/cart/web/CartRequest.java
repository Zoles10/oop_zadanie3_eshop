package sk.stuba.fei.uim.oop.assignment3.cart.web;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import java.util.List;

@Getter
@Setter
public class CartRequest {
    private Long id;
    private List<Product> shoppingCart;
    private boolean paid;
}