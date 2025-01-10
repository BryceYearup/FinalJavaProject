import java.util.HashMap;
import java.util.Scanner;

public class SocialMediaApp {

    private static HashMap<String, String> users = new HashMap<>(); // Mock "database" for storing users
    private static String loggedInUser = null; // Track the logged-in user

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (loggedInUser == null) {
                System.out.println("Welcome to the Social Media App!");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        login(scanner);
                        break;
                    case 2:
                        register(scanner);
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("\nHello " + loggedInUser + "!");
                System.out.println("1. Logout");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        logout();
                        break;
                    case 2:
                        System.out.println("Goodbye!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        // Check if the username already exists
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please try again.");
        } else {
            System.out.print("Enter a password: ");
            String password = scanner.nextLine();

            // Store the user in the mock "database"
            users.put(username, password);
            System.out.println("Registration successful! You can now log in.");
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the username exists and the password matches
        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedInUser = username;
            System.out.println("Login successful! Welcome " + username + "!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void logout() {
        System.out.println("Logging out...");
        loggedInUser = null;
    }
}

