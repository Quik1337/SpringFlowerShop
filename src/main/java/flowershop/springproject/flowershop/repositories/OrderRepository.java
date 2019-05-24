package flowershop.springproject.flowershop.repositories;

import flowershop.springproject.flowershop.models.Customer;
import flowershop.springproject.flowershop.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Set<Order> findAllByCustomer(Customer customer);
}
