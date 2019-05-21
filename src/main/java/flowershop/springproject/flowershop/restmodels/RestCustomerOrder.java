package flowershop.springproject.flowershop.restmodels;

import flowershop.springproject.flowershop.models.Customer;
import flowershop.springproject.flowershop.models.OrderDetail;
import java.util.Set;

public class RestCustomerOrder {
    
    private Long customerId;
    private Set<RestOrderDetail> orderDetails;

    public RestCustomerOrder(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomer() {
        return customerId;
    }

    public void setCustomer(Long customerId) {
        this.customerId = customerId;
    }

    public Set<RestOrderDetail> getOrderDetails() {
        return orderDetails;
    }
    
    public void setOrderDetails(Set<RestOrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}