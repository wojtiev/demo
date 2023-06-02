package com.example.demo;

public class Employee {

    public static int kolejneId = 0;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String firstName;


    public String getLastName() {
        return lastName;
    }

    public String lastName;

    public void setPosition(String position) {
        this.position = position;
    }

    public String position;
    public int employeeID;

    public int getSalary() {
        return salary;
    }

    public int salary;

    //public Employee(String firstName, String lastName, String position, int employeeID, int salary) {
        //this.firstName = firstName;
       //this.lastName = lastName;
        //this.position = position;
        //this.employeeID = employeeID;
        //this.salary = salary;
    //}

    public Employee(String firstName, String lastName, String position, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.employeeID = kolejneId++;
        this.salary = salary;
    }

    public Employee() {

    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", employeeID=" + employeeID +
                ", salary=" + salary +
                '}';
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
