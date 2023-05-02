package sk.stuba.fei.uim.oop.assignment3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.product.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.product.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class Controller {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest){
        return new ProductResponse(this.productService.create(productRequest));
    }

}
