package sk.stuba.fei.uim.oop.assignment3.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exeptions.ProductOrCartNotFoundException;
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
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> productResponses = this.productService.getAllProducts().stream().map(ProductResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(productResponses);
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = new ProductResponse(this.productService.create(productRequest));
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable("id") Long id) throws ProductOrCartNotFoundException {
        ProductResponse productResponse = new ProductResponse(this.productService.getProductById(id));
        return ResponseEntity.ok(productResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable("id") Long id, @RequestBody ProductEditRequest productEditRequest) throws ProductOrCartNotFoundException {
        ProductResponse productResponse = new ProductResponse(this.productService.updateProductById(id, productEditRequest));
        return ResponseEntity.ok(productResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable("id") Long id) throws ProductOrCartNotFoundException {
        ProductResponse productResponse = new ProductResponse(this.productService.deleteProductById(id));
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/{id}/amount")
    public ResponseEntity<ProductAmount> getAmountById(@PathVariable("id") Long id) throws ProductOrCartNotFoundException {
        ProductAmount productAmount = this.productService.getAmountById(id);
        return ResponseEntity.ok(productAmount);
    }

    @PostMapping("/{id}/amount")
    public ResponseEntity<ProductAmount> setAmountById(@PathVariable("id") Long id, @RequestBody ProductAmount productAmount) throws ProductOrCartNotFoundException {
        ProductAmount updatedProductAmount = this.productService.setAmountById(id, productAmount);
        return ResponseEntity.ok(updatedProductAmount);
    }

}
