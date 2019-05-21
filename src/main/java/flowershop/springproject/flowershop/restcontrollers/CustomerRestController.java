package flowershop.springproject.flowershop.restcontrollers;

import flowershop.springproject.flowershop.models.Customer;
import flowershop.springproject.flowershop.services.AdminService;
import flowershop.springproject.flowershop.services.CustomerService;
import flowershop.springproject.flowershop.services.FlowerService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {



    private final CustomerService customerService;


    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers")
    private Set<Customer> getCustomers(){
        return customerService.getAll();
    }

    @GetMapping("customerLogin")
    private Customer customerLogin(@RequestParam(value="email") String email,
                                   @RequestParam(value="password") String password){
        return customerService.findByEmailAndPassword(email, password);
    }

    @PostMapping("createCustomer")
    private Customer customer(@RequestBody Customer customer){
        return customerService.add(customer);
    }
}

