package flowershop.springproject.flowershop.restcontrollers;

import flowershop.springproject.flowershop.services.OrderLogicService;
import flowershop.springproject.flowershop.restmodels.RestCustomerOrder;
import flowershop.springproject.flowershop.restmodels.RestOrderDetail;
import flowershop.springproject.flowershop.services.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderRestController {
    
    private final OrderLogicService orderLogicService;

    @Autowired
    public OrderRestController(OrderLogicService orderLogicService) {
        this.orderLogicService = orderLogicService;
    }
    
    @PostMapping("createOrder")
    public OrderResponse createOrder(@RequestBody RestCustomerOrder restCustomerOrder) {
        return orderLogicService.addOrder(restCustomerOrder);
    }

    @PostMapping("createOrderTest")
    public OrderResponse createOrderTest(@RequestBody RestCustomerOrder restCustomerOrder) {
        return orderLogicService.addOrder(restCustomerOrder);
    }

    @GetMapping("createOrderForCustomer")
    public OrderResponse createOrdersForCustomer() {

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
        return orderLogicService.addOrder(restCustomerOrder);
    }


}
