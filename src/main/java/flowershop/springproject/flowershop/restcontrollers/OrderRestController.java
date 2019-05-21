package flowershop.springproject.flowershop.restcontrollers;

import flowershop.springproject.flowershop.businessLogic.OrderLogic;
import flowershop.springproject.flowershop.models.Customer;
import flowershop.springproject.flowershop.restmodels.RestCustomerOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderRestController {
    
    private final OrderLogic orderLogic;

    public OrderRestController(OrderLogic orderLogic) {
        this.orderLogic = orderLogic;
    }
    
    @PostMapping("createOrder")
    public @ResponseBody RestCustomerOrder createOrder(@RequestBody RestCustomerOrder restCustomerOrder) {
        
        return restCustomerOrder;
        //orderLogic.addOrder(customerOrder);
    }
    
    /*@PostMapping("createOrders")
    public @ResponseBody Customer createOrderTest(@RequestBody Customer customer) {
        
        return customer;
    }*/
}