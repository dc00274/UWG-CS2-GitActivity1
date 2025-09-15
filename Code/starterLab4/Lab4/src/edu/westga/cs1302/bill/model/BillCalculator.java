package edu.westga.cs1302.bill.model;

/** Stores information for a single item on a bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillCalculator {
	
/**
     * Calculates the subtotal of the given items.
     *
     * @precondition items != null && all elements of items != null
     * @postcondition none
     *
     * @param items the array of BillItem objects
     * @return the subtotal
     */	
	
public static double calculateSubtotal(BillItem[] items) {
        if (items == null) {
            throw new IllegalArgumentException("items must not be null.");
        }
        double subtotal = 0;
        for (BillItem currItem : items) {
            subtotal += currItem.getAmount();
        }
        return subtotal;
    }
}
