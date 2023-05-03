package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.CartRequest;
import sk.stuba.fei.uim.oop.assignment3.exeptions.NotFoundException;

import java.util.List;

public interface ICartService {
    List<Cart> findAll();

    Cart create(CartRequest cartRequest);
    Cart findCartById(Long id) throws NotFoundException;

    Cart deleteCartById(Long id) throws NotFoundException;
}
