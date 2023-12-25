import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RentalSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Boolean> isCarAvailable = new ArrayList<>(Arrays.asList(true, true, true, true, true, true));
    static ArrayList<Integer> Cost = new ArrayList<>(Arrays.asList(500, 700, 5000, 6000, 7000, 8000));
    static ArrayList<String> Cars = new ArrayList<>(
            Arrays.asList("Toyota", "Honda", "Mercedes", "Lexus", "Jimni", "Kia"));

    // For Adding cars(only for admin use).
    public static void AddCars(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Cars you want to add: ");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.print("Name of Car: ");
            String carname = sc.nextLine();
            Cars.add(carname);

            System.out.print("Is Car Available: ");
            boolean isAvailable = sc.nextBoolean();
            isCarAvailable.add(isAvailable);
        
            System.out.print("Base Cost Per Day: ");
            int vale = sc.nextInt();
            Cost.add(vale);
            sc.nextLine();
        }
    }

    // For deleting cars(only for admin use).
    public static void DeleteCars(){
        // System.out.print("Number of Cars you want to add: ");
        int count = 3;
        while (count == 3) {
            System.out.print("Id of Car You want to delete: ");
            int num = sc.nextInt();
            Cars.remove(num-1);

            isCarAvailable.remove(num);
            Cost.remove(num);
            sc.nextLine();
            System.out.print("Enter 0 to return to main menu: ");
            count = sc.nextInt();
        }
        
    }

    // For Valid Usernam and Password.
    public static boolean isUsernameValid(String username) {
        return username.matches("[a-zA-Z0-9_@#]+") && username.length() >= 8;
    }

    public static boolean isPasswordValid(String password) {
        return password.matches("[a-zA-Z0-9@#]+") && password.length() >= 8;
    }

    // Customer Menu
    public static void CustomerMenu() {
        System.out.println("   !!!! CUSTOMER MENU !!!! ");
        int count = 1;
        while (count == 1) {
            System.out.println("1. Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return Car");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int val = sc.nextInt();
            switch (val) {
                case 1:
                    AvailableCars();
                    break;
                case 2:
                    RentACar();
                    break;
                case 3:
                    ReturnCar();
                    break;
                case 4:
                    System.out.println("Thank You For Using \"Rajgan Car Rental System\" !!!");
                    break;
                default:
                    break;
            }
            System.out.print(
                    "If you want to return to main menu plz enter 0 otherwise you press 1 for Customer Menu: ");
            System.out.println();
            count = sc.nextInt();
            if (count == 0) {
                break;
            }
        }
    }

    // Complain portal
    public static void Complain() {
        System.out.println("   !!!! COMPLAIN PORTAL !!!! ");
        File myfile = new File("Complains.txt");
        try {
            myfile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("Complains.txt");
            Scanner sc = new Scanner(System.in);
            System.out.print("Please Enter your name: ");
            String name = sc.nextLine();
            System.out.print(name + " Please enter any query you have: ");
            String complain = sc.nextLine();
            fileWriter.write(complain);
            System.out.println(name + " Thank for your suggestions/Complain. Soon we will work on it. ");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Admin portal
    public static void Admin() {
        System.out.println("   !!!! ADMIN PORTAL !!!! ");

            Scanner sc = new Scanner(System.in);

            
            System.out.print("USERNAME: ");

            String username = sc.nextLine();

            System.out.print("PASSWORD: ");
            String password = sc.nextLine();

            if(isUsernameValid(username) && isPasswordValid(password)) {
                System.out.println("For adding Cars press 1");
                System.out.println("For deleting Cars press 2");
                System.out.print("Enter your choice: ");
                int prs = sc.nextInt();
                switch (prs) {
                    case 1:
                        AddCars();
                        break;
                    case 2:
                        DeleteCars();
                        break;
                    default:
                        System.out.println("Invalid input. ");
                        break;
                }
            } else {
                System.out.println("Username is not valid.");
            }
        }

    // Available cars
    public static void AvailableCars() {
        for (int i = 0; i < Cars.size(); i++) {
            System.out.println((i + 1) + ". " + Cars.get(i) + " --> $" + Cost.get(i) + "/day");
        }
    }

    // Rent a car
    public static void RentACar() {
        int sel;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < Cars.size(); i++) {
            System.out.println((i + 1) + ". " + Cars.get(i) + " --> $" + Cost.get(i) + "/day");
        }

        System.out.print("Enter Your Name Sir/Madam/Other: ");
        String Name = sc.nextLine();
        System.out.println();
        System.out.println("!___________________________!");
        while (true) {
            System.out.print(Name + " Enter the Car Id you want to rent: ");
            sel = sc.nextInt() - 1;
            System.out.println();

            if (sel > Cars.size() - 1) {
                System.out.println("                 Please select the right option Thank you!!!          ");
                System.out.println();
                continue;
            } else if (!isCarAvailable.get(sel)) {
                System.out.println("Sorry! "+ Name + " this Car is not Available.!!!");
                break;
            } else {
                Cars.get(sel);
                isCarAvailable.set(sel, false);
                System.out.print("Enter no of Days for Rental: ");
                int days = sc.nextInt();

                System.out.println("Cost of rental for " + days + " days is $" + (Cost.get(sel) * days));
                System.out.println("!___________________________!");
                break;
            }

        }
    }

    // Return a car
    public static void ReturnCar() {
        while (true) {
            System.out.print("Enter the Car Id you want to return: ");
            int id = sc.nextInt() - 1;
            if (!isCarAvailable.get(id)) {
                isCarAvailable.set(id, true);
                System.out.println("Car returned succesfully. Thank you!!!");
                break;
            } else if (isCarAvailable.get(id)) {
                System.out.println("This Car is already available.");
                break;
            } else {
                System.out.println("Please enter the correct Id. Thank you!!! SIR/MADAM/OTHERS");
                break;
            }
        }

    }

    // Main Menu.
    public static void main(String[] args) {
        System.out.println("                                      WELCOME TO RAJGAN CAR RENTAL SYSTEM!!! ");
        while (true) {
            System.out.println("  !!!! MAIN MENU !!!! ");
            System.out.println("1. For Customer Menu");
            System.out.println("2. For Any Complain");
            System.out.println("3. For Admin");
            System.out.println();
            System.out.print("Enter your choice: ");
            int vl = sc.nextInt();
            System.out.println();
            switch (vl) {
                case 1:
                    CustomerMenu();
                    break;
                case 2:
                    Complain();
                    break;
                case 3:
                    Admin();
                    break;

                default:
                    break;
            }
        }

    }
}
