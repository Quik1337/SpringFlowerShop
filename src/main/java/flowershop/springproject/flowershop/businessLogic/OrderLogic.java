package flowershop.springproject.flowershop.businessLogic;

import flowershop.springproject.flowershop.models.Customer;
import flowershop.springproject.flowershop.models.Order;
import flowershop.springproject.flowershop.models.OrderDetail;
import flowershop.springproject.flowershop.restmodels.RestCustomerOrder;
import flowershop.springproject.flowershop.restmodels.RestOrderDetail;
import flowershop.springproject.flowershop.services.CustomerService;
import flowershop.springproject.flowershop.services.FlowerService;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class OrderLogic {
    
    private final CustomerService customerService;
    private final FlowerService flowerService;

    public OrderLogic(CustomerService customerService, FlowerService flowerService) {
        this.customerService = customerService;
        this.flowerService = flowerService;
    }

    public String addOrder(RestCustomerOrder restCustomerOrder) {
        Customer customer = customerService.getById(restCustomerOrder.getCustomerId());
        Set<RestOrderDetail> restOrderDetails = restCustomerOrder.getRestOrderDetails();
        Order order = new Order();
        Set<OrderDetail> orderDetails = new HashSet<>();
        restOrderDetails.stream()
                .forEach(e -> orderDetails
                        .add(new OrderDetail(order, flowerService.getById(e.getFlowerId()), e.getQuantity())));


        order.setOrderDetails(orderDetails);
        order.setCustomer(customer);
        order.setOrderDate(LocalDate.now());
        order.setTotalPrice(orderDetails);
        customer.getOrders().add(order);
        customerService.add(customer);

        return "ok";
    }
}