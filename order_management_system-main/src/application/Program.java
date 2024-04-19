package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter client data");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthDate = sc.next();
		
		Client client = new Client(clientName, clientEmail, sdf.parse(birthDate));
		
		System.out.println("Enter order data: ");
		System.out.println("Enter a number for the status");
		System.out.println("0 - PENDING_PAYMENT");
		System.out.println("1 - PROCESSING");
		System.out.println("2 - SHIPPED");
		System.out.println("3 - DELIVERED");
		System.out.print("Status: ");
		
		int orderStatusNumber = sc.nextInt();
		String orderStatus = defineOrderStatus(orderStatusNumber);
		
		System.out.print("How many items to this order? ");
		int itemsQuantity = sc.nextInt();
		
		Order order = new Order(Instant.now(), OrderStatus.valueOf(orderStatus), client);
		
		for(int i = 0; i < itemsQuantity; i++) {
			sc.nextLine();
			System.out.println("Enter #" + (i+1) + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, new Product(productName, productPrice));
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println(order);
		
	}
	
	public static String defineOrderStatus(int orderStatusNumber) {
		String orderStatus;
		switch (orderStatusNumber){
		case 0: orderStatus = "PENDING_PAYMENT";
		break;
		case 1: orderStatus = "PROCESSING";
		break;
		case 2: orderStatus = "SHIPPED";
		break;
		case 3: orderStatus = "DELIVERED";
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + orderStatusNumber);
		}
		return orderStatus;
	}
	
	
}
