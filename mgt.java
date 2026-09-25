import java.util.Scanner;

public class mgt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\n===== ONLINE FOOD MANAGEMENT SYSTEM =====");
            System.out.println("1. Place Order");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine().trim();

            if (choice.equals("1")) {
                placeOrder(sc);
            } else if (choice.equals("2")) {
                running = false;
                System.out.println("Program exited. Thank you!");
            } else {
                System.out.println("Invalid choice! Please enter 1 or 2.");
            }
        }

        sc.close();
    }

    public static void placeOrder(Scanner sc) {

        try {
            System.out.print("Enter Customer Name: ");
            String customer = sc.nextLine().trim();

            System.out.print("Enter Food Name: ");
            String food = sc.nextLine().trim();

            System.out.print("Enter Quantity: ");
            int quantity = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Price: ");
            double price = Double.parseDouble(sc.nextLine().trim());

            // Validate input
            if (customer.isEmpty() || food.isEmpty()) {
                System.out.println("Error: Please enter customer name and food name!");
                return;
            }

            if (quantity <= 0 || price < 0) {
                System.out.println("Error: Quantity must be greater than 0 and price cannot be negative!");
                return;
            }

            double total = quantity * price;

            System.out.println(
                "\n========== ORDER DETAILS ==========\n"
                + "Customer Name : " + customer + "\n"
                + "Food Name     : " + food + "\n"
                + "Quantity      : " + quantity + "\n"
                + "Price         : Rs." + String.format("%.2f", price) + "\n"
                + "Total Amount  : Rs." + String.format("%.2f", total) + "\n"
                + "Order Status  : Order Placed"
            );

        } catch (NumberFormatException ex) {
            System.out.println("Input Error: Please enter valid numbers for Quantity and Price!");
        }
    }
}
