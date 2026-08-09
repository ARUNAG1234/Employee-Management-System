package com.aruna.employeemanagement.controller;

import com.aruna.employeemanagement.entity.Employee;
import com.aruna.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String employees(@RequestParam(required = false) String keyword,
                            Model model,
                            Authentication authentication) {

        model.addAttribute("employees", employeeService.search(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("username", authentication.getName());

        return "employees";
    }

    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee-view";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("pageTitle", "Add Employee");
        return "employee-form";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("pageTitle", "Edit Employee");
        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,
                               BindingResult result,
                               Model model) {

        if (result.hasErrors()) {
            model.addAttribute(
                    "pageTitle",
                    employee.getId() == null ? "Add Employee" : "Edit Employee");
            return "employee-form";
        }

        employeeService.save(employee);

        return "redirect:/employees?saved";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/employees?deleted";
    }
}
