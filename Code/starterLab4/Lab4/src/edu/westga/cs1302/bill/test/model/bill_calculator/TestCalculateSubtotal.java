package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestCalculateSubtotal {

	@Test
	public void testNullItemsThrowsException() {
        BillItem[] items = null;
        assertThrows(IllegalArgumentException.class, () -> {
            BillCalculator.calculateSubtotal(items);
        });
    }

	public void testCalculateSubtotal() {
        BillItem[] items = {
            new BillItem("Burger", 10.0),
            new BillItem("Fries", 5.0),
            new BillItem("Soda", 3.0)
        };
        double subtotal = BillCalculator.calculateSubtotal(items);
        assertEquals(18.0, subtotal, 0.001);
    }
	
	
	
}
