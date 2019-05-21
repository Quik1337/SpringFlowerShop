package flowershop.springproject.flowershop.restmodels;

public class RestOrderDetail {
    
    private Long flowerId;
    private int quantity;

    public RestOrderDetail(Long flowerId, int quantity) {
        this.flowerId = flowerId;
        this.quantity = quantity;
    }

    public Long getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(Long flowerId) {
        this.flowerId = flowerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}