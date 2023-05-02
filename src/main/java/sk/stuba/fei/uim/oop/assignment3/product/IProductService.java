package sk.stuba.fei.uim.oop.assignment3.product;


import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();
    Product create(ProductRequest productRequest);
}
