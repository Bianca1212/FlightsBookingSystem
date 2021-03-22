package ro.itschool.curs.util;

import ro.itschool.curs.enums.CustomerCategory;

public class PriceUtil {
	
	public static double ticketPrice(double price, CustomerCategory customerCategory) {
		double seniorDiscount = 0.15;
		double teenagerDiscount = 0.10;
		double childrenDiscount = 0.30;
		
		switch(customerCategory) {
		case ADULT:
			System.out.println("Ticket price is: " + price + " euro");
			break;
		case SENIOR:
			price = price - (price * seniorDiscount);
			System.out.println("Ticket price is: " + price + " euro");
			break;
		case TEENAGER:
			price = price - (price * teenagerDiscount);
			System.out.println("Ticket price is: " + price + " euro");
			break;
		case CHILDREN:
			price = price - (price * childrenDiscount);
			System.out.println("Ticket price is: " + price + " euro");
			break;
			default:
				System.err.println("INVALID");
		}
		return price;
		
	}

}
