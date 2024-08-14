package com.example.taxcalculator;

import com.example.taxcalculator.service.TaxService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

	@Test
	void TestcalculateTax2() {
		TaxService taxService = new TaxService();
		assertEquals(4156.34,taxService.calculateTaxAge(500000, 24,0, 0));
	}
	@Test
	void TestcalculateTaxwithextraincome() {
		TaxService taxService = new TaxService();
		assertEquals(6881.09,taxService.calculateTaxAge(600950, 42,50000, 0));
	}
	@Test
	void TestcalculateTaxwithextraincome2() {
		TaxService taxService = new TaxService();
		assertEquals(7674.25,taxService.calculateTaxAge(600950, 42,90000, 0));
	}
	@Test
	void TestcalculateTaxwithdeduction() {
		TaxService taxService = new TaxService();
		assertEquals(3097.42,taxService.calculateTaxAge(495982, 70,7005, 2500));
	}

	@Test
	void TestcalculateTaxwithdeduction2() {
		TaxService taxService = new TaxService();
		assertEquals(3090.76,taxService.calculateTaxAge(495982, 70,7005, 3000));
	}

	@Test
	void TestcalculatewithAge() {
		TaxService taxService = new TaxService();
		assertEquals(1450.09,taxService.calculateTaxAge(300000, 56,0, 0));
	}
	@Test
	void TestcalculatewithAge2() {
		TaxService taxService = new TaxService();
		assertEquals(776.76,taxService.calculateTaxAge(300000, 65,0, 0));
	}

	@Test
	void TestcalculatewithAge3() {
		TaxService taxService = new TaxService();
		assertEquals(650.28,taxService.calculateTaxAge(300000, 75,0, 0));
	}
	@Test
	void TestException(){
		TaxService taxService = new TaxService();
		assertThrows(IllegalArgumentException.class, ()->{
			taxService.calculateTaxAge(-495000, 23,0, 0);});
	}
}


