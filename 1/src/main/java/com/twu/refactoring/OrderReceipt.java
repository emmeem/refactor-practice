package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		output.append("======Printing Orders======\n");

		// print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());


		double totSalesTx = 0d;
		double total_amount = 0d;
		for (LineItem lineItem : o.getLineItems()) {
			output.append(lineItem.getDescription());
			output.append('\t');
			output.append(lineItem.getPrice());
			output.append('\t');
			output.append(lineItem.getQuantity());
			output.append('\t');
			output.append(lineItem.totalAmount());
			output.append('\n');


            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            total_amount += lineItem.totalAmount() + salesTax;
		}

		output.append("Sales Tax").append('\t').append(totSalesTx);

		output.append("Total Amount").append('\t').append(total_amount);
		return output.toString();
	}
}