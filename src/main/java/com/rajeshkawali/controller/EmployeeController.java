package com.rajeshkawali.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rajeshkawali.entity.Employee;
import com.rajeshkawali.service.EmployeeService;
import com.rajeshkawali.util.RecordNotFoundException;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/")
	public String getAllEmployees(Model model) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("name", "Rajesh Kawali");
		//model.addAttribute("listEmployees", list);
		return "index";
	}

	@GetMapping("/list")
	public String showEmployee(Model model) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("employee", service.getAllEmployees());
		//model.addAttribute("employee", new Employee(47L,"Rajesh","Kawali","rajeshkawali@gmail.com"));
		return "listEmployee";
	}
	@GetMapping("/addEmployee")
	public String showAddTodoPage(Model model) {
		//model.addAttribute("employee", new Employee(47L,"Rajesh","Kawali","rajeshkawali@gmail.com"));
		model.addAttribute("employee", new Employee());
		return "editEmployee";
	}
	@PostMapping("/addEmployee")
	public String addTodo(@ModelAttribute("employee") Employee employee, BindingResult result) throws RecordNotFoundException {
		if (result.hasErrors()) {
			return "index";
		}
		service.createOrUpdateEmployee(employee);
		return "redirect:/list";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) throws RecordNotFoundException {
		Employee employee = service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) throws RecordNotFoundException {
		service.createOrUpdateEmployee(employee);
		return "redirect:/";
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteEmployeeById(id);
		return "redirect:/";
	}
}
