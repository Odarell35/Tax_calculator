package com.example.taxcalculator;

import com.example.taxcalculator.service.TaxService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TaxcalculatorApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void TestcalculateTax() {
		TaxService taxService = new TaxService();
		assertEquals(4081.34,taxService.calculateTaxAge(495000, 23,0, 0));
	}
}
