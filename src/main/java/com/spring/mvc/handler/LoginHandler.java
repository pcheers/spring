package com.spring.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.editor.IdEditor;
import com.spring.mvc.model.Employee;

@Controller
@RequestMapping("/login")
public class LoginHandler {

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute Employee employee, BindingResult binding) {
		
		if(binding.hasErrors()) {
			return new ModelAndView("error");
		}
		
		return new ModelAndView("home","employee",employee);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("index", "employee", new Employee());
	}
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class,"id", new IdEditor());
	}
}
