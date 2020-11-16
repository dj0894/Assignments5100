package bank_account;


public class MyThreads extends Thread implements Runnable {

    private Person person;

    public MyThreads(Person p) {
        this.person = p;
    }

    public static void main(String[] args) {

        MyThreads thread1 = new MyThreads(new Person("Person 1"));
        thread1.start();
        MyThreads thread2 = new MyThreads(new Person("Person 2"));
        thread2.start();
        MyThreads thread3 = new MyThreads(new Person("Person 3"));
        thread3.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                BankAccount account = BankAccount.getAccount(person);
                account.withdraw(100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {

                    System.out.println(ex);
                }
                if (account.getBalance() < 0) {
                    System.out.println("Account is overdrawn ");
                }
                account.deposit(50);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Final Acc balance is Rs." + BankAccount.getBalance());
    }
}