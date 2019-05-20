package flowershop.springproject.flowershop.repositories;

import flowershop.springproject.flowershop.models.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
