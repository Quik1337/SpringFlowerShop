package flowershop.springproject.flowershop.restcontrollers;

import flowershop.springproject.flowershop.models.Customer;
import flowershop.springproject.flowershop.services.AdminService;
import flowershop.springproject.flowershop.services.CustomerService;
import flowershop.springproject.flowershop.services.FlowerService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerRestController {
    
    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("getAllCustomers")
    private Set<Customer> getCustomers(){
        return customerService.getAll();
    }
    
    @PostMapping("createCustomer")
    private Customer customer(@RequestBody Customer customer){
        return customerService.add(customer);
    }

    
}

