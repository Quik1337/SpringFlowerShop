package flowershop.springproject.flowershop.businessLogic;

import flowershop.springproject.flowershop.models.Admin;
import flowershop.springproject.flowershop.models.Customer;
import flowershop.springproject.flowershop.services.AdminService;
import flowershop.springproject.flowershop.services.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class LoginLogic {
    
    private final CustomerService customerService;
    private final AdminService adminService;

    public LoginLogic(CustomerService customerService, AdminService adminService) {
        this.customerService = customerService;
        this.adminService = adminService;
    }
    
    public Object checkUserType(String email, String password) {
        Customer customer = customerService.findByEmailAndPassword(email, password);
        Admin admin = adminService.getAdminByEmailAndPassword(email, password);
        
        if(customer != null) {
            return customer;
        }
        
        else if(admin != null) {
            return admin;
        }
        
        return null;
    }
}