package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestCalculateTax {

	@Test
	public void testCalculateTax() {
        BillItem[] items = {
            new BillItem("Burger", 10.0),
            new BillItem("Fries", 5.0),
            new BillItem("Soda", 3.0)
        };
        double tax = BillCalculator.calculateTax(items);
        assertEquals(1.8, tax, 0.001); // 10% of 18
    }
}
