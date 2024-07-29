package com.example.taxcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class TaxService {

    public double calculateTax(double income) {
        if (income <= 237100) {
            return income * 0.18;
        } else if (income <= 370500) {
            return 42678 + (income - 237100) * 0.26;
        } else if (income <= 512800) {
            return 77362 + (income - 370500) * 0.31;
        } else if (income <= 673000) {
            return 121475 + (income - 512800) * 0.36;
        } else if (income <= 857900) {
            return 179147 + (income - 673000) * 0.39;
        } else if (income <= 1817000) {
            return 251258 + (income - 857900) * 0.41;
        } else {
            return 644489 + (income - 1817000) * 0.45;
        }
    }
}
