/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop.springproject.flowershop.services;

/**
 *
 * @author buster
 */
public class OrderResponse {
    
    private boolean premium;

    public OrderResponse(boolean premium) {
        this.premium = premium;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
    
    
    
}
