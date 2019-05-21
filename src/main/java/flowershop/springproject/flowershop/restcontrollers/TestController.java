package flowershop.springproject.flowershop.restcontrollers;


import flowershop.springproject.flowershop.models.*;
import flowershop.springproject.flowershop.services.AdminService;
import flowershop.springproject.flowershop.services.CustomerService;
import flowershop.springproject.flowershop.services.FlowerService;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    private final AdminService adminService;
    private final CustomerService customerService;
    private final FlowerService flowerService;

    public TestController(AdminService adminService, CustomerService customerService, FlowerService flowerService) {
        this.adminService = adminService;
        this.customerService = customerService;
        this.flowerService = flowerService;
    }

    public void setUpDB(){
        Admin admin = new Admin();
        adminService.add(admin);
        Customer customer = new Customer();
        customer.setEmail("adam.backstrom@gmail.com");
        customer.setPassword("123");
        Order order = new Order();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
        order.getOrderDetails().add(orderDetail);
        customer.getOrders().add(order);
        customerService.add(customer);
        Flower flower = new Flower();
        flowerService.add(flower);
    }

}
