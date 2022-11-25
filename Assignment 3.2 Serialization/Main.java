import java.util.*;
import java.io.*;

public class Main {

    static String[] args = new String[0];
    static Scanner scanner = new Scanner(System.in);
    static Seller seller1 = new Seller();
    static Rider rider1 = new Rider();
    static String option;
    static double sales;
    static double salary;
    static double salary2;
    static double price;
    static double quantity;
    static double count;

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");
        System.out.flush();  
    }
    public static void Sales() {
        sales = price * quantity;
    }
    public static void sellerSalary() {
        salary = sales * .2;
    }
    public static void addSalary() {
        salary2 = sales * .2;
        salary += salary2;
        try {
            sellerSer();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public static void sellerInput() {
        System.out.print("Enter the price: P");
        price = scanner.nextDouble();
        System.out.print("Enter the quantity: ");
        quantity = scanner.nextDouble();
        scanner.nextLine();
    }
    public static void calcSales() {
        clearScreen();
        System.out.println("Calculate the Sales\n");
        sellerInput();
        Sales();
        sellerSalary();
        try {
            sellerSer();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        addSales();
    }
    public static void addSales() {
        System.out.println("\n[1] Add Sales");
        System.out.println("[2] Reset Sales");
        System.out.println("[3] Deserialize Salary");
        System.out.println("[4] Back");
        System.out.print("\nChoose your option: ");
        option = scanner.nextLine();

        switch (option) {
            case "1":
                System.out.println("\nAdd Sales\n");
                sellerInput();
                Sales();
                addSalary();
                addSales();
                break;
            case "2":
                seller1.resetSales();
                addSales();
                break;
            case "3":
                try {
                    sellerDes();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
            case "4":
                seller1.Seller();
                break;
            default:
                addSales();
        }
    }
    public static void riderSalary() {
        salary = count * 350;
    }
    public static void addRiderSalary() {
        salary2 = count * 350;
        salary += salary2;
        try {
            riderSer();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public static void resetCount() {
        salary = 0;
        System.out.println("\nRider salary is: P" + salary);
    }
    public static void addCount() {
        System.out.println("\n[1] Add Deliveries");
        System.out.println("[2] Reset Deliveries");
        System.out.println("[3] Deserialize Salary");
        System.out.println("[4] Back");
        System.out.print("\nChoose your option: ");
        option = scanner.nextLine();

        switch (option) {
            case "1":
                System.out.println("\nAdd Deliveries\n");
                addDeliveries();
                addRiderSalary();
                addCount();
                break;
            case "2":
                resetCount();
                addCount();
                break;
            case "3":
                try {
                    riderDes();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
            case "4":
                rider1.Rider();
                break;
            default:
                addCount();
        }
    }
    public static void addDeliveries() {
        System.out.print("Enter the number of deliveries: ");
        count = scanner.nextDouble();
        scanner.nextLine();
    }
    public static void deliveries() {
        clearScreen();
        System.out.println("Count Deliveries\n");
        addDeliveries();
        riderSalary();
        try {
            riderSer();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        addCount();
    }
    
    public static void main(String[] args) {
        clearScreen();
        System.out.println("Online Store\n");
        System.out.println("[1] Seller Employee");
        System.out.println("[2] Rider Employee");
        System.out.println("[3] Exit\n");
        System.out.print("Choose your option: ");
        option = scanner.nextLine();

        switch (option) {
            case "1":
                seller1.Seller();
                break;
            case "2":
                rider1.Rider();
                break;
            case "3":
                System.exit(0);
            default:
                main(args);
        }
    }

    public static void sellerSer() throws IOException, ClassNotFoundException {
        Seller seller = new Seller();

        FileOutputStream fileOut = new FileOutputStream("SellerSalary.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(seller);
        out.close();
        fileOut.close();

        System.out.println("\nSalary info serialized.");
    }
    public static void sellerDes() throws IOException, ClassNotFoundException {
        Seller seller = null;
        String filename = "SellerSalary.ser";

        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        seller = (Seller) in.readObject();
        in.close();
        fileIn.close();
    
        seller.salary();
        addSales();
    }
    public static void riderSer() throws IOException, ClassNotFoundException {
        Rider rider = new Rider();

        FileOutputStream fileOut = new FileOutputStream("RiderSalary.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(rider);
        out.close();
        fileOut.close();

        System.out.println("\nSalary info serialized.");
    }
    public static void riderDes() throws IOException, ClassNotFoundException {

        Rider rider = null;
        String filename = "RiderSalary.ser";

        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        rider = (Rider) in.readObject();
        in.close();
        fileIn.close();

        rider.riderSalary();
        addCount();
    }
}