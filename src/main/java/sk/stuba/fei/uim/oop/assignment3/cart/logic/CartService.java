package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartRepository;
import sk.stuba.fei.uim.oop.assignment3.exeptions.NotFoundException;

import java.util.List;

@Service
public class CartService implements ICartService{
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> findAll() {
        return this.cartRepository.findAll();
    }

    @Override
    public Cart create() {
        return this.cartRepository.save(new Cart());
    }

    @Override
    public Cart findCartById(Long id) throws NotFoundException{
        Cart cart = this.cartRepository.findCartById(id);
        if(cart == null) throw new NotFoundException();
        return this.cartRepository.findCartById(id);
    }

    @Override
    public Cart deleteCartById(Long id) throws NotFoundException {
        Cart cart = findCartById(id);
        this.cartRepository.delete(cart);
        return cart;
    }


}
