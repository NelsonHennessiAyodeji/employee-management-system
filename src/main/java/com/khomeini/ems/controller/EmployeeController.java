package com.khomeini.ems.controller;

import com.khomeini.ems.entity.Employee;
import com.khomeini.ems.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String listEmployees(Model model){
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "employees";
    }

    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping("/employees")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model){
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit_employee";
    }

    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model){
        System.out.println(id);
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setId(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        employeeService.updateEmployee(existingEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}