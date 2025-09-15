package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestCalculateTotal {

	@Test
	public void testCalculateTotal() {
        BillItem[] items = {
            new BillItem("Burger", 10.0),
            new BillItem("Fries", 5.0),
            new BillItem("Soda", 3.0)
        };
        double total = BillCalculator.calculateTotal(items);
        assertEquals(23.4, total, 0.001); // 18 + 1.8 + 3.6
    }


}
