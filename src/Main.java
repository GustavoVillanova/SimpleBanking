import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HomePage obj = new HomePage();
        boolean isActive = true;
        Scanner input = new Scanner(System.in);
        String name = "Gustavo Villanova";
        String accountType = "Checking";
        double balance = 1000.50;


        System.out.printf("""
        **********************************************
        Initial Customer Data:
        
        Name:           %s
        Account Type:   %s
        Initial Balance: $ %.2f
        
        **********************************************
        """, name, accountType, balance);

        // Main loop
        while (isActive) {
            int option = obj.showMenu();

            switch (option) {
                case 1 -> System.out.println("Your current balance is: $" + balance);

                case 2 -> {
                    System.out.println("Enter the amount to receive: ");
                    balance += getAmount(input);
                    System.out.println("Your new balance is: $" + balance);
                }

                case 3 -> {
                    System.out.println("Enter the amount to transfer: ");
                    balance -= getAmount(input);
                    System.out.println("Your new balance is: $" + balance);
                }

                case 4 -> {
                    isActive = false;
                    System.out.println("Exiting...");
                }

                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        input.close();
    }

    private static int getAmount(Scanner input) {
        return input.nextInt();
    }
}

class HomePage {

    public int showMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("""
        Operations:
        
        1 - Check Balance
        2 - Receive Amount
        3 - Transfer Amount
        4 - Exit
        """);

        System.out.print("Please select an option: ");
        return input.nextInt();
    }
}
