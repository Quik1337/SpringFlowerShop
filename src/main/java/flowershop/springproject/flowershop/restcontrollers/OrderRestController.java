package flowershop.springproject.flowershop.restcontrollers;

import flowershop.springproject.flowershop.businessLogic.OrderLogic;
import flowershop.springproject.flowershop.restmodels.RestCustomerOrder;
import flowershop.springproject.flowershop.restmodels.RestOrderDetail;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @GetMapping("createOrderForCustomer")
    public String createOrdersForCustomer() {

        RestCustomerOrder restCustomerOrder = new RestCustomerOrder();
        restCustomerOrder.setCustomerId(1L);
        RestOrderDetail restOrderDetail = new RestOrderDetail();
        restOrderDetail.setFlowerId(1L);
        restOrderDetail.setQuantity(3);
        RestOrderDetail restOrderDetail1 = new RestOrderDetail();
        restOrderDetail1.setFlowerId(2L);
        restOrderDetail1.setQuantity(4);
        Set<RestOrderDetail> restOrderDetailSet = new HashSet<>();
        restOrderDetailSet.add(restOrderDetail);
        restOrderDetailSet.add(restOrderDetail1);
        restCustomerOrder.setRestOrderDetails(restOrderDetailSet);
        return orderLogic.addOrder(restCustomerOrder);
    }


}
