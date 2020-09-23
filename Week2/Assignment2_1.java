package edu.aed.week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employee {

        String name;
        int age;
        Gender gender;
        double salary;// salary per month

        // Constructor. Please set all the data in constructor.
        public Employee(String name, int age, Gender gender, double salary) {
                this.name=name;
                this.age=age;
                this.gender=gender;
                this.salary=salary;
        }

        // Getter for `name`. Return the current `name` data
        public String getName() {
            return name;
        }

        // Setter for `name`. Set `name` data
        public void setName(String name) {
            this.name=name;
        }

        public double getSalary(){
            return salary;

        }

        public void setSalary(double salary){

            this.salary=salary;

            //System.out.println(this.salary);

        }
        public void raiseSalary(double byPercent){

            this.salary=this.salary+(byPercent/100)*this.salary;

            System.out.println("\n"+"Increased salary="+ this.salary);
        }


    }

    enum Gender {
        MALE,
        FEMALE;
    }

    public class Assignment2_1{
        // Assignment

        /**
         * Write a method to calculate the Social Security Tax of an employee and print it.
         * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
         * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
         */
        public double socialSecurityTax(Employee employee) {
            double socialSecurityTx=0.0;
            if(employee.salary<=8900){
                socialSecurityTx= 0.062 * employee.salary;

            }else {
                socialSecurityTx = 0.062 * 106800;
            }
          return  socialSecurityTx ;
        }


        /**
         * Write a method to calculate an employee's contribution for insurance coverage and print it.
         * Amount of deduction is computed as follows:
         * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
         * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
         */
        public double insuranceCoverage(Employee employee) {
            double rate=0.0;
            if(employee.age<35){
                rate=0.03*employee.salary;
        }else if(employee.age>=35&&employee.age<=50){
                rate=0.04*employee.salary;
        }else if(employee.age>50&& employee.age<60){
                rate=0.05*employee.salary;
        }else {
                rate=0.06*employee.salary;
        }

         return rate;
        }

        /**
         * Write a method to sort three employees' salary from low to high, and then print their name in order.
         * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
         * John Alice Jenny
         */
        public static void sortSalary(Employee e1, Employee e2, Employee e3) {

            List<Employee> employeeList= Arrays.asList(e1,e2,e3);
            Comparator<Employee> employeeSalaryComparator=Comparator.comparing(Employee::getSalary);
            employeeList.sort(employeeSalaryComparator);
            employeeList.stream().forEach(employee -> System.out.print(employee.getName()+" "));


        }

        /**
         * Write a method to raise an employee's salary to three times of his/her original salary.
         * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
         * Do not change the input of this method.
         * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
         */

        public void tripleSalary(Employee employee) {
            employee.raiseSalary(200);

        }



        //Extra credit

        /**
         * I have written some code below. What I want is to swap two Employee objects.
         * One is Jenny and one is John. But after running it, I got the result below:
         * Before: a=Jenny
         * Before: b=John
         * After: a=Jenny
         * After: b=John
         * There is no change after swap()! Do you know the reason why my swap failed?
         * Write your understanding of the reason and explain it.
         */
    /*

    when we printed both objects a and b before and after swapping, hashcode of the object has not been swapped.
    So we can conclude that in java when we are assigning one object to another, only reference is assigned not actual values.

    // if we want to swap only names then we can do it manually using below code in swap method.
            String temp1=x.name;
            x.name=y.name;
            y.name=temp1;

    */
        public static void main(String[] args) {
            Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
            Employee b = new Employee("John", 30, Gender.MALE, 2500);
            Employee c= new Employee("Peter", 30, Gender.MALE, 500);//deepika
            System.out.println("Before: a=" + a.getName());
            System.out.println("Before: b=" + b.getName());
            System.out.println("a is refering to "+a); //deepika
            System.out.println("b is refering to "+b); //deepika

            swap(a, b);

            System.out.println("After: a=" + a.getName());
            System.out.println("After: b=" + b.getName());
            System.out.println("a is refering to "+a);//hashcode has not changed even after swapping
            System.out.println("b is refering to "+b);//hascode has not changed even after swaping

            Assignment2_1 obj=new Assignment2_1();//Creating object of Assignment2_1 class
            System.out.println(obj.socialSecurityTax(c));// printing social security tax
            System.out.println(obj.insuranceCoverage(c));// insurance coverage
            obj.sortSalary(a,b,c);//Sorting objects on the basis of salary
            obj.tripleSalary(c);// Increasing salary to triple i.e 200% hike.
        }

        public static void swap(Employee x, Employee y) {
            Employee temp = x;
            x = y;
            y = temp;


        }
    }

