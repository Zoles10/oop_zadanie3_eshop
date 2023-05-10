package sk.stuba.fei.uim.oop.assignment3.product.logic;


import sk.stuba.fei.uim.oop.assignment3.exeptions.ProductOrCartNotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductEditRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductRequest;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();
    Product create(ProductRequest productRequest);
    Product getProductById(Long id) throws ProductOrCartNotFoundException;
    Product updateProductById(Long id, ProductEditRequest productEditRequest) throws ProductOrCartNotFoundException;
    Product deleteProductById(Long id) throws ProductOrCartNotFoundException;
    ProductAmount getAmountById(Long id) throws ProductOrCartNotFoundException;
    ProductAmount setAmountById(Long id, ProductAmount amount) throws ProductOrCartNotFoundException;
}
