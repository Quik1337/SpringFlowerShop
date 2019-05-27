package flowershop.springproject.flowershop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderDetail> orderDetails = new HashSet<>();

    private BigDecimal totalPrice;
    private LocalDate orderDate;

    public Order() {
    }

    public Order(Customer customer, BigDecimal totalPrice, LocalDate orderDate) {
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Set<OrderDetail> orderDetails) {
        BigDecimal orderCost = new BigDecimal(orderDetails.stream()
                .map(e -> e.getFlower().getPrice().multiply(new BigDecimal(e.getQuantity()))).mapToDouble(BigDecimal::doubleValue).sum());

        if(this.customer.getPremium()){
            orderCost = orderCost.multiply(new BigDecimal("0.90")).setScale(2, RoundingMode.CEILING);
        }
        this.totalPrice = orderCost;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }


}