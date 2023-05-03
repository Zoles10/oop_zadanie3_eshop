package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.data.ProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductEditRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.ProductRequest;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product create(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setUnit(productRequest.getUnit());
        product.setAmount(productRequest.getAmount());
        return this.productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return this.productRepository.findProductById(id);
    }

    @Override
    public Product updateProductById(Long id, ProductEditRequest productEditRequest) {
        Product editedProduct = this.productRepository.findProductById(id);
        editedProduct.setName(productEditRequest.getName());
        editedProduct.setDescription(productEditRequest.getDescription());
        return this.productRepository.save(editedProduct);
    }

    @Override
    public Product deleteProductById(Long id){
        Product deletedProduct = this.productRepository.findProductById(id);
        this.productRepository.delete(deletedProduct);
        return deletedProduct;
    }

    @Override
    public ProductAmount getAmountById(Long id){
        ProductAmount productAmount = new ProductAmount();
        productAmount.setAmount(this.productRepository.findProductById(id).getAmount());
        return productAmount;
    }

    @Override
    public ProductAmount setAmountById(Long id, ProductAmount amount){
        ProductAmount productAmount = new ProductAmount();
        Product editedProduct = this.productRepository.findProductById(id);
        editedProduct.setAmount(amount.getAmount());
        this.productRepository.save(editedProduct);
        productAmount.setAmount(editedProduct.getAmount());
        return productAmount;
    }

}
