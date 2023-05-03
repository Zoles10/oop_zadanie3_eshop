package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.CartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.CartRequest;
import sk.stuba.fei.uim.oop.assignment3.cart.web.CartResponse;
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
    public CartResponse addCart(@RequestBody CartRequest cartRequest){
        return new CartResponse(this.cartService.create(cartRequest));
    }

    @GetMapping("/{id}")
    public CartResponse findCartById(@PathVariable("id") Long id) throws NotFoundException {
        return new CartResponse(this.cartService.findCartById(id));
    }

    @DeleteMapping("/{id}")
    public CartResponse deleteCartById(@PathVariable("id") Long id) throws NotFoundException{
        return new CartResponse(this.cartService.deleteCartById(id));
    }
}

