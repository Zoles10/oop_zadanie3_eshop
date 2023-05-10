package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exeptions.IllegalProductOrCartOperationException;
import sk.stuba.fei.uim.oop.assignment3.exeptions.ProductOrCartNotFoundException;

import java.util.List;

public interface ICartService {
    List<Cart> findAll();

    Cart create();
    Cart findCartById(Long id) throws ProductOrCartNotFoundException;

    Cart deleteCartById(Long id) throws ProductOrCartNotFoundException;
    Cart addProductToCart(Long cartId, CartItemRequest cartItemRequest) throws ProductOrCartNotFoundException, IllegalProductOrCartOperationException;

    double payForCart(Long cardId) throws ProductOrCartNotFoundException, IllegalProductOrCartOperationException;
}
