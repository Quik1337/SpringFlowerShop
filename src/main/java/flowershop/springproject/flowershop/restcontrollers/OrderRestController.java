package flowershop.springproject.flowershop.restcontrollers;

import flowershop.springproject.flowershop.businessLogic.OrderLogic;
import flowershop.springproject.flowershop.restmodels.RestCustomerOrder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderRestController {
    
    private final OrderLogic orderLogic;

    public OrderRestController(OrderLogic orderLogic) {
        this.orderLogic = orderLogic;
    }
    
    @PostMapping("createOrder")
    public String createOrder(@RequestBody RestCustomerOrder restCustomerOrder) {
        return orderLogic.addOrder(restCustomerOrder);
    }

    @PostMapping("createOrderTest")
    public String createOrderTest(@RequestBody RestCustomerOrder restCustomerOrder) {
        return orderLogic.addOrder(restCustomerOrder);
    }
}