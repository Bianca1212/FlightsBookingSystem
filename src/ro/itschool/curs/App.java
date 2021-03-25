
package ro.itschool.curs;

import java.util.Scanner;

import ro.itschool.curs.entity.Customer;
import ro.itschool.curs.entity.Flight;
import ro.itschool.curs.entity.Ticket;
import ro.itschool.curs.enums.CustomerCategory;
import ro.itschool.curs.service.CustomerService;
import ro.itschool.curs.service.FlightService;
import ro.itschool.curs.util.PriceUtil;

public class App {

	public static void main(String[] args) throws Exception {

		FlightService flightService = new FlightService();
		flightService.findFlightById(1);
		
		Customer customer = new Customer();
		CustomerService customerService = new CustomerService();
		Scanner scanner = new Scanner(System.in);
		String firstName, lastName, email, category;
		System.out.println("Enter your first name:");
		firstName = scanner.next();
		customer.setFirstName(firstName);
		System.out.println("Enter your last name:");
		lastName = scanner.next();
		customer.setLastName(lastName);
		System.out.println("Enter your email address:");
		email = scanner.next();
		customer.setEmail(email);
		System.out.println("Enter your age category based on:");
		System.out.println("SENIOR(65+ years)");
		System.out.println("ADULT(>18 years)");
		System.out.println("TEENAGER(12-18 years)");
		System.out.println("CHILDREN(2-11 years)");
		category = scanner.next();
		CustomerCategory customerCategory = CustomerCategory.valueOf(category);
		customer.setCustomerCategory(customerCategory);
		customerService.saveCustomer(customer);

		String departurePlace, destination, seat;
		int id;
		System.out.println("Enter your departure place:");
		departurePlace = scanner.next();
		System.out.println("Enter your destination: ");
		destination = scanner.next();
		System.out.println(flightService.findFlightByCity(departurePlace, destination));
		System.out.println("Choose your destination id:");
		id = scanner.nextInt();
		Flight selectedFlight = flightService.findFlightById(id);
		System.out.println(selectedFlight);
		System.out.println("Select a seat:");
		seat = scanner.next();
		while (!selectedFlight.getSeats().get(seat)) {
			System.out.println("Seat not available, please select another one!");
			seat = scanner.next();
		}
		System.out.println(selectedFlight.getSeats().put(seat, false));
		flightService.updateFlight(selectedFlight);

		Ticket ticket = selectedFlight.getTicket();
		System.out.println("Please enter again your age category for price calculation:");
		String category1 = scanner.next();
		CustomerCategory customerCategory1 = CustomerCategory.valueOf(category1);
		PriceUtil.ticketPrice(ticket.getPrice(), customerCategory1);

		scanner.close();
	}

}
