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
 
/**
 * Calculates the tip on the given items.
 * 
 * @param items the array of BillItem objects
 * @return the subtotal times tip rate
 */
public static double calculateTip(BillItem[] items) {
    return calculateSubtotal(items) * Bill.TIP_RATE;
}

/**
 * Calculates the tax on given items.
 * 
 *  @param items the array of BillItem objects
 * @return subtotal times tax rate
 */
public static double calculateTax(BillItem[] items) {
    return calculateSubtotal(items) * Bill.TAX_RATE;
 }

}
