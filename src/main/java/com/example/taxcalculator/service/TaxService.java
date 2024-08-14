package com.example.taxcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class TaxService {

    public double calculateTax(double income) {
        if (income < 0) {
            throw new IllegalArgumentException("Income cannot be negative.");
        }

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


    public double calculateTaxAge(double income, int age, double additional, double deductions) {
        if (income < 0) {
            throw new IllegalArgumentException("Income cannot be negative.");
        }

        income = income + (additional - deductions);

        final double[] brackets = {95750, 148217, 165689, 237100, 370500, 512800, 673000, 857900, 1817000, 10000000};

        final double[] ratesUnder65 = {0.00, 0.03, 0.07, 0.09, 0.13, 0.18, 0.22, 0.26, 0.31, 0.39, 0.45};
        final double[] rates65to74 = {0.00, 0.00, 0.01, 0.04, 0.10, 0.16, 0.21, 0.24, 0.30, 0.39, 0.45};
        final double[] rates75Plus = {0.00, 0.00, 0.00, 0.03, 0.09, 0.15, 0.20, 0.24, 0.30, 0.39, 0.45};

        double tax = 0.0;
        if (age <= 65) {
            tax = calculateTax(income, brackets, ratesUnder65);
        } else if (age <= 75) {
            tax = calculateTax(income, brackets, rates65to74);
        } else {
            tax = calculateTax(income, brackets, rates75Plus);
        }

        double finalTax = tax / 12;
        finalTax = Math.round(finalTax * 100.0) / 100.0;
        return finalTax;
    }

    private double calculateTax(double income, double[] brackets, double[] rates) {
        double tax = 0.0;
        double previousBracket = 0.0;

        for (int i = 0; i < brackets.length; i++) {
            double currentBracket = brackets[i];
            double rate = rates[i];

            if (income > currentBracket) {
                tax += (currentBracket - previousBracket) * rate;
                previousBracket = currentBracket;
            } else {
                tax += (income - previousBracket) * rate;
                break;
            }
        }
        return tax;
    }

}
