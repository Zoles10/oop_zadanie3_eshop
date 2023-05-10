package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartRepository;
import sk.stuba.fei.uim.oop.assignment3.cart.web.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exeptions.IllegalProductOrCartOperationException;
import sk.stuba.fei.uim.oop.assignment3.exeptions.ProductOrCartNotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.logic.ProductService;

import java.util.List;

@Service
public class CartService implements ICartService{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartItemService cartItemService;

    @Override
    public List<Cart> findAll() {
        return this.cartRepository.findAll();
    }

    @Override
    public Cart create() {
        return this.cartRepository.save(new Cart());
    }

    @Override
    public Cart findCartById(Long id) throws ProductOrCartNotFoundException {
        Cart cart = this.cartRepository.findCartById(id);
        if(cart == null) throw new ProductOrCartNotFoundException();
        return cart;
    }

    @Override
    public Cart deleteCartById(Long id) throws ProductOrCartNotFoundException {
        Cart cart = findCartById(id);
        this.cartRepository.delete(cart);
        return cart;
    }

    @Override
    public Cart addProductToCart(Long cartId, CartItemRequest cartItemRequest) throws ProductOrCartNotFoundException, IllegalProductOrCartOperationException {
        Cart cart = findUnpaidCart(cartId);
        if(cart.isPayed() || productService.getProductById(cartItemRequest.getProductId()).getAmount() < cartItemRequest.getAmount() ){
            throw new IllegalProductOrCartOperationException();
        }
        for(CartItem cartItem : cart.getShoppingList()){
            Long currentCartId = cartItem.getProduct().getId();
            if(currentCartId.equals(cartItemRequest.getProductId())){
                Long currentAmount = cartItem.getAmount();
                Long requestedAmount = cartItemRequest.getAmount();
                cartItem.setAmount(currentAmount + requestedAmount);
                Long amountInStock = productService.getProductById(currentCartId).getAmount();
                productService.getProductById(currentCartId).setAmount(amountInStock - requestedAmount);
                return this.cartRepository.save(cart);
            }
        }
        CartItem cartItem = cartItemService.create(productService.getProductById(cartItemRequest.getProductId()), cartItemRequest.getAmount());
        productService.getProductById(cartItemRequest.getProductId()).setAmount(productService.getProductById(cartItemRequest.getProductId()).getAmount() - cartItemRequest.getAmount());
        cart.getShoppingList().add(cartItem);
        return this.cartRepository.save(cart);
    }

    @Override
    public double payForCart(Long cardId) throws ProductOrCartNotFoundException, IllegalProductOrCartOperationException {
        Cart cart = findUnpaidCart(cardId);
        cart.setPayed(true);
        double price = 0.0;
        for(CartItem cartItem : cart.getShoppingList()){
            price += cartItem.getProduct().getPrice() * (double)cartItem.getAmount();
        }
        this.cartRepository.save(cart);
        return price;
    }

    private Cart findUnpaidCart(Long id) throws IllegalProductOrCartOperationException, ProductOrCartNotFoundException{
        Cart cart = findCartById(id);
       if(!cart.isPayed()) return cart;
       else {
           throw new IllegalProductOrCartOperationException();
       }
    }

}
