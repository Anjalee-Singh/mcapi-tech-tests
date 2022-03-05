package com.application.controller;


import com.application.service.CalculateCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.product.ShoppingCart;

@RestController
@RequestMapping("totalcost")
public class ShoppingCartController {

    @Autowired
    private CalculateCostService calculateCostService;

    @PostMapping
    public Double getBook(@RequestBody ShoppingCart shoppingCart) {
        Double abCart = null;
        Double otherCart = null;
        if(shoppingCart.getCostForA() != null || shoppingCart.getCostForB()  != null) {
            abCart = calculateCostService.totalCost(shoppingCart.getCostForA(), shoppingCart.getCostForB());
        } else{
            otherCart = calculateCostService.totalCost(shoppingCart.getCostForA(), shoppingCart.getCostForB());
        }
        return Double.sum(abCart,otherCart);
    }

}
