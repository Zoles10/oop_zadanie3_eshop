package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<CartItem> shoppingList;
    private boolean payed;

    public Cart() {
        this.shoppingList = new ArrayList<>();
    }
}
