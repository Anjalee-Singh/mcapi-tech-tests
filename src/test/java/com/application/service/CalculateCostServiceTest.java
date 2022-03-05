package com.application.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculateCostServiceTest {

    @InjectMocks
    CalculateCostServiceImpl calculateCostServiceImpl;

    @Test
    public void totalCostTest(){
        Double value= calculateCostServiceImpl.totalCost(10.00, 9.00);
        Assert.assertEquals(14.50, value, 0.001);
    }
}
