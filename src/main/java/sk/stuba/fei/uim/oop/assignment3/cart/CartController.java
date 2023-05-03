package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.CartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.cart.web.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.exeptions.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exeptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping()
    public List<CartResponse> getAllCarts(){
        return this.cartService.findAll().stream().map(CartResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<CartResponse> addCart(){
        return new ResponseEntity<>(new CartResponse(this.cartService.create()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CartResponse findCartById(@PathVariable("id") Long id) throws NotFoundException {
        return new CartResponse(this.cartService.findCartById(id));
    }

    @DeleteMapping("/{id}")
    public CartResponse deleteCartById(@PathVariable("id") Long id) throws NotFoundException{
        return new CartResponse(this.cartService.deleteCartById(id));
    }

    @PostMapping("/{id}/add")
    public CartResponse addProductToCart(@PathVariable("id") Long cartId, @RequestBody CartItemRequest cartItemRequest) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.cartService.addProductToCart(cartId, cartItemRequest));
    }

    @GetMapping("/{id}/pay")
    public String payForCart(@PathVariable("id") Long cartId) throws NotFoundException, IllegalOperationException {
        return String.valueOf(this.cartService.payForCart(cartId));
    }
}

