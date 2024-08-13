package com.example.taxcalculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxServiceTest {

    @Test
    void TestcalculateTax() {
        TaxService taxService = new TaxService();
        assertEquals(4081.34,taxService.calculateTaxAge(495000, 23,0, 0));
    }
}