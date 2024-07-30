package com.example.taxcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class TaxService {

    private static final int TAXPAYER_CREDIT_2024 = 364;
    private static final int DEPENDANT_CREDIT_2024 = 246;

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

    public static double calculateTaxAge(double income, int age, int dependants, boolean isMember) {
        double tax = 0.0;
        double finalTax = 0.0;
        if (income < 0) {
            throw new IllegalArgumentException("Income cannot be negative.");
        }

        // Calculate the basic tax based on age and income
        if (age < 65) {
            if (income <= 95750) {
                tax = 0;
            } else if (income <= 148217) {
                tax = (income - 95750) * 0.03;
            } else if (income <= 165689) {
                tax = (148217 - 95750) * 0.03 + (income - 148217) * 0.07;
            } else if (income <= 237100) {
                tax = (148217 - 95750) * 0.03 + (165689 - 148217) * 0.07 + (income - 165689) * 0.09;
            } else if (income <= 370500) {
                tax = (148217 - 95750) * 0.03 + (165689 - 148217) * 0.07 + (237100 - 165689) * 0.09 + (income - 237100) * 0.13;
            } else if (income <= 512800) {
                tax = (148217 - 95750) * 0.03 + (165689 - 148217) * 0.07 + (237100 - 165689) * 0.09 + (370500 - 237100) * 0.13 + (income - 370500) * 0.18;
            } else if (income <= 673000) {
                tax = (148217 - 95750) * 0.03 + (165689 - 148217) * 0.07 + (237100 - 165689) * 0.09 + (370500 - 237100) * 0.13 + (512800 - 370500) * 0.18 + (income - 512800) * 0.22;
            } else if (income <= 857900) {
                tax = (148217 - 95750) * 0.03 + (165689 - 148217) * 0.07 + (237100 - 165689) * 0.09 + (370500 - 237100) * 0.13 + (512800 - 370500) * 0.18 + (673000 - 512800) * 0.22 + (income - 673000) * 0.26;
            } else if (income <= 1817000) {
                tax = (148217 - 95750) * 0.03 + (165689 - 148217) * 0.07 + (237100 - 165689) * 0.09 + (370500 - 237100) * 0.13 + (512800 - 370500) * 0.18 + (673000 - 512800) * 0.22 + (857900 - 673000) * 0.26 + (income - 857900) * 0.31;
            } else if (income <= 10000000) {
                tax = (148217 - 95750) * 0.03 + (165689 - 148217) * 0.07 + (237100 - 165689) * 0.09 + (370500 - 237100) * 0.13 + (512800 - 370500) * 0.18 + (673000 - 512800) * 0.22 + (857900 - 673000) * 0.26 + (1817000 - 857900) * 0.31 + (income - 1817000) * 0.39;
            } else {
                tax = (148217 - 95750) * 0.03 + (165689 - 148217) * 0.07 + (237100 - 165689) * 0.09 + (370500 - 237100) * 0.13 + (512800 - 370500) * 0.18 + (673000 - 512800) * 0.22 + (857900 - 673000) * 0.26 + (1817000 - 857900) * 0.31 + (10000000 - 1817000) * 0.39 + (income - 10000000) * 0.45;
            }
        } else if (age < 75) {
            if (income <= 95750) {
                tax = 0;
            } else if (income <= 148217) {
                tax = 0;
            } else if (income <= 165689) {
                tax = (income - 148217) * 0.01;
            } else if (income <= 237100) {
                tax = (165689 - 148217) * 0.01 + (income - 165689) * 0.04;
            } else if (income <= 370500) {
                tax = (165689 - 148217) * 0.01 + (237100 - 165689) * 0.04 + (income - 237100) * 0.10;
            } else if (income <= 512800) {
                tax = (165689 - 148217) * 0.01 + (237100 - 165689) * 0.04 + (370500 - 237100) * 0.10 + (income - 370500) * 0.16;
            } else if (income <= 673000) {
                tax = (165689 - 148217) * 0.01 + (237100 - 165689) * 0.04 + (370500 - 237100) * 0.10 + (512800 - 370500) * 0.16 + (income - 512800) * 0.21;
            } else if (income <= 857900) {
                tax = (165689 - 148217) * 0.01 + (237100 - 165689) * 0.04 + (370500 - 237100) * 0.10 + (512800 - 370500) * 0.16 + (673000 - 512800) * 0.21 + (income - 673000) * 0.24;
            } else if (income <= 1817000) {
                tax = (165689 - 148217) * 0.01 + (237100 - 165689) * 0.04 + (370500 - 237100) * 0.10 + (512800 - 370500) * 0.16 + (673000 - 512800) * 0.21 + (857900 - 673000) * 0.24 + (income - 857900) * 0.30;
            } else if (income <= 10000000) {
                tax = (165689 - 148217) * 0.01 + (237100 - 165689) * 0.04 + (370500 - 237100) * 0.10 + (512800 - 370500) * 0.16 + (673000 - 512800) * 0.21 + (857900 - 673000) * 0.24 + (1817000 - 857900) * 0.30 + (income - 1817000) * 0.39;
            } else {
                tax = (165689 - 148217) * 0.01 + (237100 - 165689) * 0.04 + (370500 - 237100) * 0.10 + (512800 - 370500) * 0.16 + (673000 - 512800) * 0.21 + (857900 - 673000) * 0.24 + (1817000 - 857900) * 0.30 + (10000000 - 1817000) * 0.39 + (income - 10000000) * 0.45;
            }
        } else {
            if (income <= 95750) {
                tax = 0;
            } else if (income <= 148217) {
                tax = 0;
            } else if (income <= 165689) {
                tax = 0;
            } else if (income <= 237100) {
                tax = (income - 165689) * 0.03;
            } else if (income <= 370500) {
                tax = (237100 - 165689) * 0.03 + (income - 237100) * 0.09;
            } else if (income <= 512800) {
                tax = (237100 - 165689) * 0.03 + (370500 - 237100) * 0.09 + (income - 370500) * 0.15;
            } else if (income <= 673000) {
                tax = (237100 - 165689) * 0.03 + (370500 - 237100) * 0.09 + (512800 - 370500) * 0.15 + (income - 512800) * 0.20;
            } else if (income <= 857900) {
                tax = (237100 - 165689) * 0.03 + (370500 - 237100) * 0.09 + (512800 - 370500) * 0.15 + (673000 - 512800) * 0.20 + (income - 673000) * 0.24;
            } else if (income <= 1817000) {
                tax = (237100 - 165689) * 0.03 + (370500 - 237100) * 0.09 + (512800 - 370500) * 0.15 + (673000 - 512800) * 0.20 + (857900 - 673000) * 0.24 + (income - 857900) * 0.30;
            } else if (income <= 10000000) {
                tax = (237100 - 165689) * 0.03 + (370500 - 237100) * 0.09 + (512800 - 370500) * 0.15 + (673000 - 512800) * 0.20 + (857900 - 673000) * 0.24 + (1817000 - 857900) * 0.30 + (income - 1817000) * 0.39;
            } else {
                tax = (237100 - 165689) * 0.03 + (370500 - 237100) * 0.09 + (512800 - 370500) * 0.15 + (673000 - 512800) * 0.20 + (857900 - 673000) * 0.24 + (1817000 - 857900) * 0.30 + (10000000 - 1817000) * 0.39 + (income - 10000000) * 0.45;
            }
        }

        // Calculate medical scheme credits for 2024
        double medicalTaxCredit = isMember ? TAXPAYER_CREDIT_2024 + (dependants * DEPENDANT_CREDIT_2024) : dependants * DEPENDANT_CREDIT_2024;
        
        // Apply medical scheme credits
        double finalTaxAfterCredits = tax - (medicalTaxCredit * 12);
        double finalTax = finalTaxAfterCredits / 12;

        // Ensure tax liability is not negative
        return Math.max(finalTax, 0);
    }

    // Overloaded method without dependants and isMember
    public static double calculateBasic(double income, int age) {
        return calculateTaxAge(income, age, 0, false); // Default values: 0 dependants, not a member
    }

}
