package emailapp;

import java.security.SecureRandom;
import java.util.Scanner;

public class Email {

    private String lastName;
    private String firstName;
    private String department;
    private String email;
    private String password;
    private String alternateEmail;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;

        System.out.println("New Worker : "+ this.firstName+" "+this.lastName+". ");
        this.department=setDepartment();
        this.password=randomPassword(defaultPasswordLength);
        if(this.department==""){
            email=firstName.toLowerCase() + "." + lastName.toLowerCase() + "@"  + companySuffix;
        }else {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + (this.department).toLowerCase() + "." + companySuffix;
        }
    }


    // Ask for the department
    private String setDepartment() {

            System.out.println("Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None");
            System.out.println("Enter the department code: ");
            Scanner sc = new Scanner(System.in);
            int departmentId = sc.nextInt();

            if (departmentId == 1) {
               department = "Sales";
            } else if (departmentId == 2) {
                department = "Dev";
            } else if (departmentId == 3) {
                department = "Accounting";
            } else {
                department ="";
            }
            return department;
}


    // Generate a random password
    private String randomPassword(int length) {
        final String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(passwordSet.length());
            sb.append(passwordSet.charAt(randomIndex));
        }

        return sb.toString();
    }

    public void setmailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;

    }


    public void setAlternateEmail(String email) {
        this.alternateEmail = email;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName(){
        return getFirstName()+" "+getLastName();
    }

    public String getEmail() {
        return email;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String showInfo() {

        String output="DISPLAY NAME:"+ this.getName()+"\nDEPARTMENT: "+ this.department+ "\nCOMPANY EMAIL:"+ this.getEmail()+"\nPASSWORD: "+this.password+"\nMAILBOX CAPACITY: "+this.getMailboxCapacity()+"mb";


        return output;
    }
}

