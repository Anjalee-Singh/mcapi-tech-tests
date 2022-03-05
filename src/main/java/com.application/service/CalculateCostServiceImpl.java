package  com.application.service;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

@Service
public class CalculateCostServiceImpl implements CalculateCostService{


    @Override
    public Double totalCost(Double costForA, Double costForB) {
        if(costForA != null){
           return  Double.sum(costForA, costForB/2);
        }

        return costForB;
    }

    @Override
    public Double totalCost(Double costForX, Double costForY, Double costForZ, Double costForP, Double costForQ, Double costForR) {
        Double totalCost = null;
        Double[] arr = {costForX, costForY, costForZ, costForP, costForQ, costForR};
        arr = Arrays.stream(arr)
                .filter(s -> (s != null ))
                .toArray(Double[]::new);

        if( arr.length >= 3){
            Arrays.sort(arr);
        }
        Arrays.copyOfRange(arr, 1, arr.length);
        for (double val : arr) {
            totalCost += val;
        }
        return totalCost;
    }
}