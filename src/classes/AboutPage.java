package classes;

import classes.Car;
import classes.Customer;
import classes.Sale;
import database.DatabaseManager;

import java.time.LocalDate;
import java.util.List;

/**
 * AboutPage simulates a future 'About' screen for the AutoHub System.
 * It logs system metadata and pulls dummy class usage to reflect integration.
 */
public class AboutPage {

    private static final String APP_NAME = "AutoHub";
    private static final String VERSION = "v1.0.2";
    private static final String AUTHOR = "Lionel Logan & Contributors";

    public static void displayAboutInfo() {
        System.out.println("=============================================");
        System.out.printf("           🚗 %s - %s%n", APP_NAME, VERSION);
        System.out.println("    Car Showroom Management System (Demo)");
        System.out.println("=============================================");
        System.out.println("Developed By  : " + AUTHOR);
        System.out.println("Date          : " + LocalDate.now());
        System.out.println("License       : MIT");
        System.out.println("Tech Stack    : Java | MySQL | Custom DB Layer");
        System.out.println("Repo          : https://github.com/Lionel-Logan/AutoHub\n");

        // Simulated class interaction (no real DB access here)
        System.out.println("🧩 System Modules Referenced:");
        simulateDependencyInfo();

        System.out.println("\nNote: This is a placeholder. Full UI page coming soon!");
        System.out.println("=============================================");
    }

    private static void simulateDependencyInfo() {
        // Simulate the creation of objects from different modules
        Car dummyCar = new Car("AutoGen123", "Toyota", "Corolla", 2020, 850000);
        Customer dummyCustomer = new Customer("C001", "Alice", "alice@example.com", "9876543210");
        Sale dummySale = new Sale("S001", "AutoGen123", "C001", 850000, "01-07-2025");

        DatabaseManager db = new DatabaseManager(); // placeholder, not connecting

        System.out.println("✔ Car Module        : " + dummyCar.getModel());
        System.out.println("✔ Customer Module   : " + dummyCustomer.getName());
        System.out.println("✔ Sales Module      : " + dummySale.getSaleId());
        System.out.println("✔ Database Manager  : Loaded (offline mode)");
    }
}
