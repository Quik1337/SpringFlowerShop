package flowershop.springproject.flowershop.restmodels;

import java.util.Set;

public class RestCustomerOrder {
    
    private Long customerId;
    private Set<RestOrderDetail> restOrderDetails;

    public RestCustomerOrder() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Set<RestOrderDetail> getRestOrderDetails() {
        return restOrderDetails;
    }

    public void setRestOrderDetails(Set<RestOrderDetail> restOrderDetails) {
        this.restOrderDetails = restOrderDetails;
    }
}