package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exeptions.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exeptions.NotFoundException;

import java.util.List;

public interface ICartService {
    List<Cart> findAll();

    Cart create();
    Cart findCartById(Long id) throws NotFoundException;

    Cart deleteCartById(Long id) throws NotFoundException;
    Cart addProductToCart(Long cartId, CartItemRequest cartItemRequest) throws NotFoundException, IllegalOperationException;

    double payForCart(Long cardId) throws NotFoundException, IllegalOperationException;
}
