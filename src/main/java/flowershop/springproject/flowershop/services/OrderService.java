package flowershop.springproject.flowershop.services;

import flowershop.springproject.flowershop.models.Customer;
import flowershop.springproject.flowershop.models.Order;
import flowershop.springproject.flowershop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class OrderService implements CrudService<Order> {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Order> getAll() {
        Set<Order> orders = new HashSet<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public Order add(Order object) {
        return orderRepository.save(object);
    }

    public Set<Order> getAllOrdersForCustomer(Customer customer){
        Set<Order> orders = new HashSet<>();
        orderRepository.findAllByCustomer(customer).forEach(orders::add);
        return orders;
    }
}
