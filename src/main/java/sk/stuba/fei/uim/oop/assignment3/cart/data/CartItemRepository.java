package sk.stuba.fei.uim.oop.assignment3.cart.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    CartItem findShoppingCartItemById(Long id);
}
