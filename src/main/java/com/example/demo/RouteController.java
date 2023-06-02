package com.example.demo;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {
    static HashMap<Integer, Employee> employeeHashMap = new HashMap();
    static EmployeeManager employeeManager = new EmployeeManager(employeeHashMap);

    public static void addtomanager() {
        employeeManager.addEmployee("John", "Doe", "Manager", 75000);
        employeeManager.addEmployee("Jane", "Smith", "Accountant", 60000);
        employeeManager.addEmployee("Michael", "Johnson", "Accountant", 55000);
        employeeManager.addEmployee("Emily", "Jones", "Marketing Specialist", 50000);

        System.out.println("cos");
    }

    @GetMapping({"/dodaj"})
    public String form(Model model) {
        model.addAttribute("Employee", new Employee());
        return "dodaj";
    }

    @GetMapping({"/"})
    public String displayEmployees(Model model) {
        model.addAttribute("employeeManager", employeeManager);
        return "index";
    }

    @GetMapping({"/edytuj/{id}"})
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Employee employee = employeeManager.searchEmployeeByID(id);
        model.addAttribute("employee", employee);
        return "edytuj";
    }

    @PostMapping({"/usun/{id}"})
    public String deleteEmployee(@PathVariable("id") int id) {
        System.out.println(id);
        employeeManager.removeEmployee(employeeManager.searchEmployeeByID(id));
        return "redirect:/";
    }

    @PostMapping({"/updatuj/{id}"})
    public String updateEmployee(@PathVariable("id") String id, @ModelAttribute("employee") Employee updatedEmployee) {
        employeeManager.updateEmployee(Integer.parseInt(id), updatedEmployee.getPosition(), updatedEmployee.getSalary());
        return "redirect:/";
    }

    @PostMapping({"/szukajPoNazwisku"})
    public String searchByLastName(@RequestParam("lastName") String lastName, Model model) {
        model.addAttribute("lastName", lastName);
        model.addAttribute("employeeManager", employeeManager);
        return "szukajPoNazwisku";
    }

    @PostMapping({"/zapiszPracownika"})
    public String addEmployeeToHashList(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("position") String position,@RequestParam("salary") int salary) {
        System.out.println(firstName+ " "+firstName+ " "+lastName+ " "+position+ " "+ salary);
        employeeManager.addEmployee(firstName, lastName, position, salary);
        return "redirect:/dodaj";
    }
}