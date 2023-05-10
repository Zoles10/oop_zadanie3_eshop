package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

public interface ICartItemService {
    CartItem create(Long id);
    CartItem findShoppingCartItemById(Long id);
    CartItem create(Product product, Long amount);
}
