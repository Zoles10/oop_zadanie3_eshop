package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItemRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    CartItem findShoppingCartItemById(Long id) {
        return this.cartItemRepository.findShoppingCartItemById(id);
    }

    CartItem create(Product product, int amount) {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setAmount(amount);
        return this.cartItemRepository.save(cartItem);
    }
}
