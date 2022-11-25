import java.io.*;
import java.util.*;

public class Seller extends Main implements Serializable {
    
    public static void salary() {
        System.out.println("\nSeller salary is: P" + salary);
    }
    public static void resetSales() {
        salary = 0;
        System.out.println("\nSeller salary is: P" + salary);
    }
    public static void Seller() {
        clearScreen();
        System.out.println("Seller Employee\n");
        System.out.println("[1] Compute Salary");
        System.out.println("[2] Back to Menu\n");
        System.out.print("Choose your option: ");
        option = scanner.nextLine();

        switch (option) {
            case "1":
                calcSales();
                break;
            case "2":
                main(args);
                break;
            default:
                Seller();
        }
    }
}