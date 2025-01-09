import java.util.ArrayList;

// BankAccount Class
class BankAccount {
    // Attributes of the bank account
    private String accountNumber; // Unique account number
    private String accountHolderName; // Name of the account holder
    private double balance; // Current balance of the account

    // Constructor to initialize the account
    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber; // Assign account number
        this.accountHolderName = accountHolderName; // Assign account holder name
        this.balance = initialDeposit; // Set initial deposit as balance
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) { // Check if the deposit amount is positive
            balance += amount; // Add the amount to the balance
            System.out.println("Depositing $" + amount + " into account " + accountNumber + "..."); // Print deposit confirmation
            System.out.println("New balance: $" + balance); // Print new balance
        } else {
            System.out.println("Invalid deposit amount."); // Print error for invalid deposit
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) { // Check if sufficient funds are available
            balance -= amount; // Deduct the amount from the balance
            System.out.println("Withdrawing $" + amount + " from account " + accountNumber + "..."); // Print withdrawal confirmation
            System.out.println("New balance: $" + balance); // Print new balance
            return true; // Return true if successful
        } else {
            System.out.println("Insufficient funds or invalid amount."); // Print error for insufficient funds
            return false; // Return false if unsuccessful
        }
    }

    // Accessor method to get account number
    public String getAccountNumber() {
        return accountNumber; // Return the account number
    }

    // Accessor method to get account holder name
    public String getAccountHolderName() {
        return accountHolderName; // Return the account holder name
    }

    // Accessor method to get balance
    public double getBalance() {
        return balance; // Return the current balance
    }
}

// Customer Class
class Customer {
    // Attributes of the customer
    private String name; // Name of the customer
    private String customerId; // Unique customer ID
    private ArrayList<BankAccount> accounts; // List to store customer's bank accounts

    // Constructor to initialize the customer
    public Customer(String name, String customerId) {
        this.name = name; // Assign customer name
        this.customerId = customerId; // Assign customer ID
        this.accounts = new ArrayList<>(); // Initialize the list of accounts
    }

    // Method to add a bank account to the customer
    public void addAccount(BankAccount account) {
        accounts.add(account); // Add the account to the list
        System.out.println("Adding a savings account for " + name + " with account number");
        System.out.println(account.getAccountNumber() + " and an initial deposit of $" + account.getBalance() + "."); // Print confirmation
    }

    // Method to get an account by its account number
    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) { // Iterate through the accounts list
            if (account.getAccountNumber().equals(accountNumber)) { // Check if account number matches
                return account; // Return the matching account
            }
        }
        return null; // Return null if no account matches
    }

    // Method to display all accounts of the customer
    public void displayAccounts() {
        System.out.println("Displaying all accounts for customer " + name + ":"); // Print header
        for (BankAccount account : accounts) { // Iterate through the accounts
            System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: $" + account.getBalance()); // Print account details
        }
    }

    // Accessor method to get customer name
    public String getName() {
        return name; // Return the customer name
    }

    // Accessor method to get customer ID
    public String getCustomerId() {
        return customerId; // Return the customer ID
    }
}

// Bank Class
class Bank {
    // Attributes of the bank
    private String bankName;

    // Accessor method to get the bank name
    public String getBankName() {
        return bankName;
    }
    private ArrayList<Customer> customers; // List to store the bank's customers

    // Constructor to initialize the bank
    public Bank(String bankName) {
        this.bankName = bankName; // Assign the bank name
        this.customers = new ArrayList<>(); // Initialize the list of customers
    }

    // Method to add a customer to the bank
    public void addCustomer(Customer customer) {
        customers.add(customer); // Add the customer to the list
        System.out.println("Creating a new customer: " + customer.getName() + " (ID: " + customer.getCustomerId() + ")"); // Print confirmation
    }

    // Method to get a customer by their customer ID
    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) { // Iterate through the customers list
            if (customer.getCustomerId().equals(customerId)) { // Check if customer ID matches
                return customer; // Return the matching customer
            }
        }
        return null; // Return null if no customer matches
    }

    // Method to display all customers of the bank
    public void displayAllCustomers() {
        System.out.println("Displaying all customers of " + bankName + ":"); // Print header
        for (Customer customer : customers) { // Iterate through the customers
            System.out.println("Customer: " + customer.getName() + ", ID: " + customer.getCustomerId()); // Print customer details
        }
    }
}

// Main Class
public class Viva3Q5 {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank("SimpleBank"); // Creates a new Bank object with the name "SimpleBank".
        System.out.println("Welcome to " + bank.getBankName() + "!"); // Print welcome message

        // Create a customer
        Customer customer1 = new Customer("John Doe", "C001"); // Create a new customer
        bank.addCustomer(customer1); // Add the customer to the bank

        // Add a savings account for the customer
        BankAccount account1 = new BankAccount("A1001", "John Doe", 500.0); // Create a new bank account
        customer1.addAccount(account1); // Add the account to the customer
        
        // Create a customer
        Customer customer2 = new Customer("Louis", "C002"); // Create a new customer
        bank.addCustomer(customer2); // Add the customer to the bank

        // Add a savings account for the customer
        BankAccount account2 = new BankAccount("A1002", "Louis", 500.0); // Create a new bank account
        customer2.addAccount(account2); // Add the account to the customer
 
        // Perform transactions
        account1.deposit(200.0); // Deposit money into the account
        account1.withdraw(100.0); // Withdraw money from the account

        // Display account details for the customer
        customer1.displayAccounts(); // Display all accounts of the customer
        customer2.displayAccounts();

        // Display all customers in the bank
        bank.displayAllCustomers(); // Display all customers of the bank
    }
}
