import java.util.Map;
import java.util.HashMap;


public class Customer{
     String id;
     int pin;
     String name;
     double balance;

    public Customer(String id, int pin, String name, double balance) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public int getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public  double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
     
    
    }
    
    class Bank {
    
        private Map<String, Customer> customers;
    
        public Bank() {
            customers = new HashMap<>();
        }
            
        public void addCustomer(String id,int pin,String name,double balance) {
            customers.put(id, new Customer(id, pin, name, balance));
        }
        
    
    
    // Cash In
        public void CashIn( String id,double amount) {
            Customer customer = customers.get(id);
            customer.setBalance(customer.getBalance()+amount);
            System.out.println("Cash In successful. New balance: " + customer.getBalance());
    }

// Money Transfer
    public void MoneyTransfer(String id, double amount) {
        Customer customer = customers.get(id);
        if (id.equals(customer.getId())) {
            if (customer.getBalance() >= amount) {
                customer.setBalance(customer.getBalance() - amount);
                System.out.println("Transfer successful. Current balance: " + customer.getBalance());
            } else {
                System.out.println("Insufficient balance.");
            }
        }else {
            System.out.println("Account not Found");
        }
    }
    // check balance
    public void checkBalance(String id) {
        Customer customer = customers.get(id);
            System.out.println("Balance: " + customer.getBalance());
    }

    public void displayCustomerInfo(String id) {
        Customer customer = customers.get(id);
        System.out.println("Customer Detail \nID : " + customer.getId()+ " Name : " + customer.getName() + " Pin : " + customer.getPin() + " Balance : " + customer.getBalance());
    }
    

    }



