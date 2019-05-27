package flowershop.springproject.flowershop.services;

import flowershop.springproject.flowershop.models.Customer;
import flowershop.springproject.flowershop.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerService implements CrudService<Customer> {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Customer> getAll() {
        Set<Customer> customers = new HashSet<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer getCustomerByEmailAndPassword(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Customer add(Customer object) {
        return customerRepository.save(object);
    }
}