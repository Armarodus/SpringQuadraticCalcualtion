package quadratic.quadratic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import quadratic.quadratic.model.Calculation;
import quadratic.quadratic.model.dto.CalculationDto;
import quadratic.quadratic.service.CalculationService;

@Controller
public class CalculationController {

	@Autowired
	private CalculationService calcService;
	
	/*
	 * Return base page with calculation form
	 */
	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("calculation",new CalculationDto());
		return "home";
	}
	
	/*
	 * Return result page with all calculated data
	 */
	@PostMapping("/calc")
	public String calcualate(@Valid CalculationDto calculation,Model model) {
		model.addAttribute("calc", calcService.calculate(calculation));
		return "result";
	}
}
