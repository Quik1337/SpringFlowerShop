package flowershop.springproject.flowershop.businessLogic;

import flowershop.springproject.flowershop.models.Customer;
import flowershop.springproject.flowershop.models.Order;
import flowershop.springproject.flowershop.models.OrderDetail;
import flowershop.springproject.flowershop.restmodels.RestCustomerOrder;
import flowershop.springproject.flowershop.restmodels.RestOrderDetail;
import flowershop.springproject.flowershop.services.CustomerService;
import flowershop.springproject.flowershop.services.FlowerService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import flowershop.springproject.flowershop.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderLogic {
    
    private final CustomerService customerService;
    private final FlowerService flowerService;
    private final OrderService orderService;

    public OrderLogic(CustomerService customerService, FlowerService flowerService, OrderService orderService) {
        this.customerService = customerService;
        this.flowerService = flowerService;
        this.orderService = orderService;
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
        updatePremiumStatus(orderDetails, customer);
        customerService.add(customer);

        return "ok";
    }

    public void updatePremiumStatus(Set<OrderDetail> orderDetails, Customer customer){
       BigDecimal orderAmount = new BigDecimal(orderDetails.stream()
                .map(e -> e.getFlower().getPrice().multiply(new BigDecimal(e.getQuantity()))).mapToDouble(BigDecimal::doubleValue).sum());
       BigDecimal oldAmount = new BigDecimal(orderService.getAllOrdersForCustomer(customer)
                                            .stream()
                                            .map(e -> e.getTotalPrice())
                                            .mapToDouble(BigDecimal::doubleValue).sum());

       if(oldAmount.add(orderAmount).compareTo(new BigDecimal("5000")) == 1){
            customer.setPremium(true);
       }
    }
}