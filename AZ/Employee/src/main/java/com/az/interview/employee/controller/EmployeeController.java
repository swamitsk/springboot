package com.az.interview.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.az.interview.employee.domain.Employee;
import com.az.interview.employee.domain.EmployeeRepository;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;

	@RequestMapping(value="",method=RequestMethod.GET)
		public String reserve(Model model)
	{
		model.addAttribute("employees",repository.findAll());
		return "employees/list";
	}
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
		public ModelAndView delete(@PathVariable long id)
		{
			repository.delete(id);
			return new ModelAndView("redirect:/employees");
		}
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String newEmployee()
	{
		return "employees/new";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView create(@RequestParam("name") String name,@RequestParam("department") String department,
			@RequestParam("location") String location)
	{
		repository.save(new Employee(name,department,location));
		return new ModelAndView("redirect:/employees");
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView edit(@RequestParam("employee_id") long id, @RequestParam("department") String department,
			@RequestParam("location") String location)
	{
		Employee emp= repository.findOne(id);
		emp.setDepartment(department);
		emp.setLocation(location);
		repository.save(emp);
		return new ModelAndView("redirect:/employees");
	}
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public String edit(@PathVariable long id,Model model)
	{
		Employee emp= repository.findOne(id);
		model.addAttribute("employee",emp);
		repository.save(emp);
		return ("employees/edit");
	}


}
