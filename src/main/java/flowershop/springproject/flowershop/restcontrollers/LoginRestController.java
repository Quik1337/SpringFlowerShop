package flowershop.springproject.flowershop.restcontrollers;

import flowershop.springproject.flowershop.models.Admin;
import flowershop.springproject.flowershop.models.Customer;
import flowershop.springproject.flowershop.services.AdminService;
import flowershop.springproject.flowershop.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginRestController {
    
    private final AdminService adminService;
    private final CustomerService customerService;

    @Autowired
    public LoginRestController(AdminService adminService, CustomerService customerService) {
        this.adminService = adminService;
        this.customerService = customerService;
    }
    
    @GetMapping("customerLogin")
    private Customer customerLogin(@RequestParam(value="email") String email,
                           @RequestParam(value="password") String password){
        return customerService.getCustomerByEmailAndPassword(email, password);
    }

    @GetMapping("adminLogin")
    private Admin adminLogin(@RequestParam(value="email") String email,
                             @RequestParam(value="password") String password){
        return adminService.getAdminByEmailAndPassword(email, password);
    }
}