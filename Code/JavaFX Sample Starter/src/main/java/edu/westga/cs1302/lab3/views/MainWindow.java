package edu.westga.cs1302.lab3.views;


import edu.westga.cs1302.lab3.model.Bill;
import edu.westga.cs1302.lab3.model.BillItem;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainWindow {
	 @FXML
	    private TextField amount;

	    @FXML
	    private TextField name;

	    @FXML
	    private TextArea output;
	    
        private Bill bill;
        private BillView billView;
        
	    @FXML
	    void addItem(ActionEvent event) {
	    	try {
	    		String billName = name.getText();
	    		double billAmount = Double.parseDouble(billName);
	    		BillItem item = new BillItem(billName, billAmount);
	    		bill.addItem(item);
	    		String billText = billView.getText(bill);
	    		output.setText(billText);
	    		
	    	}catch (IllegalArgumentException e) {
	    		output.setText(e.getMessage());
	    	}
	    }

    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	billView =  new BillView();
    	bill = new Bill();
    }
    
    
    
}
