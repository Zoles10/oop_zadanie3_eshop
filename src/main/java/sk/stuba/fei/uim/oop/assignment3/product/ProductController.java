package sk.stuba.fei.uim.oop.assignment3.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exeptions.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductEditRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.product.logic.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductResponse> getAllProducts(){
        return this.productService.getAllProducts().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest){
        return new ProductResponse(this.productService.create(productRequest));
    }

    @GetMapping("/{id}")
    public ProductResponse findProductById(@PathVariable("id") Long id) throws NotFoundException {
        return new ProductResponse(this.productService.getProductById(id));
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long id, @RequestBody ProductEditRequest productEditRequest) throws NotFoundException{
        return new ProductResponse(this.productService.updateProductById(id, productEditRequest));
    }

    @DeleteMapping("/{id}")
    public ProductResponse deleteProduct(@PathVariable("id") Long id) throws NotFoundException{
        return new ProductResponse(this.productService.deleteProductById(id));
    }

    @GetMapping("/{id}/amount")
    public ProductAmount getAmountById(@PathVariable("id") Long id) throws NotFoundException{
        return this.productService.getAmountById(id);
    }

    @PostMapping("/{id}/amount")
    public ProductAmount setAmountById(@PathVariable("id") Long id, @RequestBody ProductAmount productAmount) throws NotFoundException{
        return this.productService.setAmountById(id, productAmount);
    }


}
