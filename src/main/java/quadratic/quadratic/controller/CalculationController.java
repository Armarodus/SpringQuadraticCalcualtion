package quadratic.quadratic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import quadratic.quadratic.model.Calculation;
import quadratic.quadratic.service.CalculationService;

@Controller
public class CalculationController {

	@Autowired
	private CalculationService calcService;
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("calculation",new Calculation());
		return "home";
	}
	

	@PostMapping("/calc")
	public String calcualate(@Valid Calculation calculation,Model model) {
		model.addAttribute("calc", calcService.calculate(calculation));
		return "result";
	}
}
