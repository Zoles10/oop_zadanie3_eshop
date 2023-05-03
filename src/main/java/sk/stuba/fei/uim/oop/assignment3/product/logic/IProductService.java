package sk.stuba.fei.uim.oop.assignment3.product.logic;


import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductEditRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductRequest;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();
    Product create(ProductRequest productRequest);
    Product getProductById(Long id);
    Product updateProductById(Long id, ProductEditRequest productEditRequest);
    Product deleteProductById(Long id);
}
