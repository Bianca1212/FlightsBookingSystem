
package ro.itschool.curs;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import ro.itschool.curs.entity.Customer;
import ro.itschool.curs.entity.Flight;
import ro.itschool.curs.enums.CustomerCategory;
import ro.itschool.curs.service.CustomerService;
import ro.itschool.curs.service.FlightService;

public class App {

	public static void main(String[] args) throws Exception {
	
		FlightService flightService = new FlightService();
//		Customer customer = new Customer();
//		CustomerService customerService = new CustomerService();
		Scanner scanner = new Scanner(System.in);
//		String firstName, lastName, email, category;
//		System.out.println("Enter your first name:");
//		firstName = scanner.next();
//		customer.setFirstName(firstName);
//		System.out.println("Enter your last name:");
//		lastName = scanner.next();
//		customer.setLastName(lastName);
//		System.out.println("Enter your email address:");
//		email = scanner.next();
//		customer.setEmail(email);
//		System.out.println("Enter your age category based on:");
//		System.out.println("SENIOR(65+ years)");
//		System.out.println("ADULT(>18 years)");
//		System.out.println("TEENAGER(12-18 years)");
//		System.out.println("CHILDREN(2-11 years)");
//		category = scanner.next();
//		CustomerCategory customerCategory = CustomerCategory.valueOf(category);
//		customer.setCustomerCategory(customerCategory);
//		customerService.saveCustomer(customer);

		String departurePlace, destination, seat;
		int id;
		System.out.println("Enter your departurePlace:");
		departurePlace = scanner.next();
		System.out.println("Enter your destination: ");
		destination = scanner.next();
		System.out.println(flightService.findFlightByCity(departurePlace, destination));
//		System.out.println("Enter your destination id:");
//		id = scanner.nextInt();
//		System.out.println(flightService.findFlightById(id));
//		System.out.println("Select a seat:");
//		seat = scanner.next();
//		Flight selectedFlight = flightService.findFlightById(id);
//		System.out.println(selectedFlight.getSeats().put(seat, false));
//		flightService.updateFlight(selectedFlight);
		
		scanner.close();
	}

}
