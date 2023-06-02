package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class EmployeeManager {

    private final HashMap<Integer,Employee> employees;

    public HashMap<Integer, Employee> getEmployees() {
        return this.employees;
    }

    public EmployeeManager(HashMap<Integer, Employee> employees) {
        this.employees = employees;
    }

    //public  void addEmployee(Employee employee){
       //Integer keyEmployee = employee.getEmployeeID();
       //employees.put(keyEmployee,employee);
    //}

    public void addEmployee(String firstName, String lastName, String position, int salary) {
        Employee employee = new Employee(firstName, lastName, position, salary);
        Integer keyEmployee = employee.getEmployeeID();
        this.employees.put(keyEmployee, employee);
    }


    public void removeEmployee(Employee employee){
        if(employees.containsKey(employee.getEmployeeID()))
            employees.remove(employee.getEmployeeID());
        else
            System.out.println("Pracownik o takim ID nie istnieje");
    }

    //public void updateEmployee(int employeeID, Employee newEmployee){
        //if(employees.containsKey(employeeID))
        //{
            //employees.put(employeeID,newEmployee);
        //}
        //else
           //System.out.println("Pracownik o takim ID nie istnieje");
    //}

    public void updateEmployee(int employeeID, String newPosition, int newSalary) {
        if (searchEmployeeByID(employeeID) != null){
            Employee e = searchEmployeeByID(employeeID);
            e.setPosition(newPosition);
            e.setSalary(newSalary);
        } else {
            System.out.println("Pracownik o takim ID nie istnieje");
        }

    }

    public Employee searchEmployeeByID(int employeeID) {
        if(employees.containsKey(employeeID)){
            return employees.get(employeeID);
        }
        else
            System.out.println("Nie znaleziono pracownika o danym ID");
           return null;
    }
    public void listAllEmployees(){
        ArrayList<Employee> employeeList = new ArrayList<>(employees.values());
        for (Employee employee: employeeList
             ) {
            System.out.println(employee);
        }
    }
    public HashSet<Employee> searchEmployeesByPosition(String position){
         HashSet<Employee> employeeList = new HashSet<>(employees.values());
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while(employeeIterator.hasNext())
        {
            Employee employee = employeeIterator.next();
            if(!employee.getPosition().equals(position))
                employeeIterator.remove();
        }
        return employeeList;
    }

    /*public HashSet<Employee> searchEmployeesByLastName(String lastname){
        HashSet<Employee> employeeList = new HashSet<>(this.employees.values());
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while(employeeIterator.hasNext())
        {
            Employee employee = (Employee)employeeIterator.next();
            if(!employee.getLastName().equals(lastname))
                employeeIterator.remove();
        }
        return employeeList;
    }
    */
    public HashSet<Employee> searchEmployeesByLastName(String lastName) {
        HashSet<Employee> employeeList = new HashSet(this.employees.values());
        Iterator<Employee> employeeIterator = employeeList.iterator();

        while(employeeIterator.hasNext()) {
            Employee employee = (Employee)employeeIterator.next();
            if (!employee.getLastName().equals(lastName)) {
                employeeIterator.remove();
            }
        }

        return employeeList;
    }


}
