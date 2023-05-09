package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Product product;
    private Long amount;

    public CartItem(Product product, Long amount) {
        this.product = product;
        this.amount = amount;
    }
}
