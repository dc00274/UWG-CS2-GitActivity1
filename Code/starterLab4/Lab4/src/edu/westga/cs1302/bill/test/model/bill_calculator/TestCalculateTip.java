package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestCalculateTip {

	@Test
	public void testCalculateTip() {
            BillItem[] items = {
            new BillItem("Burger", 10.0),
            new BillItem("Fries", 5.0),
            new BillItem("Soda", 3.0)
        };
       double tip = BillCalculator.calculateTip(items);
       assertEquals(3.6, tip, 0.001); // 20% of 18
    }

}
