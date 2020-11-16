package bank_account;

public class BankAccount {
    public static BankAccount account;
    private static int balance = 1000;
    private static Person person;

    private BankAccount() {
    }

    public static BankAccount getAccount(Person p) {
        if (account == null) {
            account = new BankAccount();
        }
        BankAccount.person = p;
        return account;
    }

    public static int getBalance() {
        return balance;

    }

    public synchronized void withdraw(int amount) {
        try {

            if (balance >= amount) {

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance = balance - amount;

            } else {
                System.out.println(person.getName() + " " + "doesn't have enough money to withdraw ");
            }
            System.out.println(person.getName() + " " + " withdrawed Rs." + amount);
            System.out.println("Current balance in account is : "+ getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(int amount) {
        try {
            if (amount > 0) {

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance = balance + amount;

            } else {
                System.out.println(person.getName() + " " + "doesn't have enough money for deposit");
            }
            System.out.println(person.getName() + " " + " deposited Rs. " + amount);
            System.out.println("Current balance after deposit "+getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}