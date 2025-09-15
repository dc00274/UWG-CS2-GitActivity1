package edu.westga.cs1302.bill.view;

import java.util.ArrayList;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

/** Supports displaying the information contained in a Bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillView {

	/** Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param bill the bill to be viewed
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	@SuppressWarnings("unused")
	public static String getText(Bill bill) {
		String text = "ITEMS" + System.lineSeparator();
		ArrayList<BillItem> itemList = bill.getItems();
		BillItem[] items = itemList.toArray(new BillItem[0]);
		double subTotal = 0.0;
		for (BillItem item : bill.getItems()) {
			text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
			subTotal += item.getAmount();
		}
		
		double subtotal = BillCalculator.calculateSubtotal(items);
        double tip = BillCalculator.calculateTax(items);
        double tax = BillCalculator.calculateTip(items);
        @SuppressWarnings("unused")
		double total = BillCalculator.calculateTotal(items);
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + subTotal + System.lineSeparator();
		text += "TAX - $" + BillView.roundToNearestHundredth(tax) + System.lineSeparator();
		text += "TIP - $" + BillView.roundToNearestHundredth(tip) + System.lineSeparator();
		text += "TOTAL - $" + BillView.roundToNearestHundredth(subTotal + tip + tax);
		
		return text;
	}
	
	private static double roundToNearestHundredth(double value) {
		return (int) (value * 100) / 100.0;
	}
}
