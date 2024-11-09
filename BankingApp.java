
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
// Main Class
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //Random ID
        int randomNumber = random.nextInt(100000);

        int cPin1;
        double cCashIn=0;

        String cId =String.valueOf(randomNumber);
        // Login

        System.out.println("Welcome to Banking System");
        System.out.println("Please Register");

        System.out.print("Enter your Name : ");
        String cName = scanner.nextLine();

        System.out.print("Enter your 4 Digit Pin : ");
        String cPins = scanner.nextLine();
        //String nPins = Integer.parseInt(cPin);
        if (cPins.length() <= 4 && cPins.matches("\\d*")) {
            int nPin = Integer.parseInt(cPins);
            try {
                System.out.print("Initial Cash In : ");
                cCashIn = scanner.nextInt();
                System.out.print("\033c"); //clear console
            } catch (RuntimeException e) {
                System.err.println("Enter a valid amount");
                System.exit(0);
            }

            System.out.println("Your ID :" + cId);
            
            bank.addCustomer(cId, nPin, cName, cCashIn);
            bank.addCustomer("7890",1236,"Marco Yim",1000);

            try {
            System.out.println("Pleas Login \nEnter your 4 Digit Pin");
            cPin1 = scanner.nextInt();
            
            if (cPin1 == nPin) {
                System.out.print("\033c"); //clear console
                bank.displayCustomerInfo(cId);
                while (true) {
                    System.out.println("Select transaction \n 1: Cash In \n 2: Money Transfer \n 3: Check Balance \n 4: Exit");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                        System.out.print("\033c"); //clear console
                            System.out.print("Enter amount to Cash In : ");
                            double depositAmount = scanner.nextDouble();
                            bank.CashIn(cId,depositAmount);
                            break;
                        case 2:
                        System.out.print("\033c"); //clear console
                            try {
                                System.out.println("Enter Account Number:");
                                 cId = scanner.next();
                                System.out.print("Enter amount to transfer: ");
                                double AmountToTransfer = scanner.nextDouble();
                                bank.MoneyTransfer(cId, AmountToTransfer);
                            }catch (InputMismatchException e) {
                                System.out.println("Invalid Input");
                                System.exit(0);
                            }
                            break;
                        case 3:
                        System.out.print("\033c"); //clear console
                            bank.checkBalance(cId);
                            break;
                        case 4:
                            System.exit(0);
                            break;
                        default:
                            System.err.println("Invalid Choice Try Again");
                    }
                }
           
        } else {
            System.err.println("Invalid input Please enter a number with up to 4 digits.");
        }
    
    } catch (InputMismatchException e) {
    System.out.println("Enter valid digit");
    scanner.next();
    } finally{
        scanner.close();
    }
        

    }
    }
}




