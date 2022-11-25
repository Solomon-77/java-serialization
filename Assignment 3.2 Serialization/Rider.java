import java.io.*;
import java.util.*;

public class Rider extends Main implements Serializable {

    public static void riderSalary() {
        System.out.println("\nRider salary is: P" + salary);
    }
    public static void Rider() {
        clearScreen();
        System.out.println("Rider Employee\n");
        System.out.println("[1] Compute Salary");
        System.out.println("[2] Back to Menu\n");
        System.out.print("Choose your option: ");
        option = scanner.nextLine();

        switch (option) {
            case "1":
                deliveries();
                break;
            case "2":
                main(args);
                break;
            default:
                Rider();
        }
    }
}