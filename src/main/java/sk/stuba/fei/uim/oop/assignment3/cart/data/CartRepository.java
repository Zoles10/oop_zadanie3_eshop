package sk.stuba.fei.uim.oop.assignment3.cart.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    List<Cart> findAll();
    Cart findCartById(Long id);
}
