package com.barbara.service;

public class BrazilTaxService {
    public double calculateTax(double basicPayment) {
        if (basicPayment <= 100)
            return basicPayment * 0.20;

        return basicPayment * 0.15;
    }
}