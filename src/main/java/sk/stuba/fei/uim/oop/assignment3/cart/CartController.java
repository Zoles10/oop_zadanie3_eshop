package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.CartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.cart.web.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.exeptions.IllegalProductOrCartOperationException;
import sk.stuba.fei.uim.oop.assignment3.exeptions.ProductOrCartNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping()
    public ResponseEntity<List<CartResponse>> getAllCarts(){
        List<CartResponse> cartResponses = this.cartService.findAll().stream().map(CartResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(cartResponses);
    }

    @PostMapping()
    public ResponseEntity<CartResponse> addCart(){
        CartResponse cartResponse = new CartResponse(this.cartService.create());
        return new ResponseEntity<>(cartResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> findCartById(@PathVariable("id") Long id) throws ProductOrCartNotFoundException {
        CartResponse cartResponse = new CartResponse(this.cartService.findCartById(id));
        return ResponseEntity.ok(cartResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CartResponse> deleteCartById(@PathVariable("id") Long id) throws ProductOrCartNotFoundException {
        CartResponse cartResponse = new CartResponse(this.cartService.deleteCartById(id));
        return ResponseEntity.ok(cartResponse);
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<CartResponse> addProductToCart(@PathVariable("id") Long cartId, @RequestBody CartItemRequest cartItemRequest) throws ProductOrCartNotFoundException, IllegalProductOrCartOperationException {
        CartResponse cartResponse = new CartResponse(this.cartService.addProductToCart(cartId, cartItemRequest));
        return ResponseEntity.ok(cartResponse);
    }

    @GetMapping("/{id}/pay")
    public ResponseEntity<String> payForCart(@PathVariable("id") Long cartId) throws ProductOrCartNotFoundException, IllegalProductOrCartOperationException {
        String response = String.valueOf(this.cartService.payForCart(cartId));
        return ResponseEntity.ok(response);
    }

}

