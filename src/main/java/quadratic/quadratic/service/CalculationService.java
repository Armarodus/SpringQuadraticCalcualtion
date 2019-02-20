package quadratic.quadratic.service;

import quadratic.quadratic.model.Calculation;
import quadratic.quadratic.model.dto.CalculationDto;

public interface CalculationService {
	/*
	 * Returns Calculation object that contains a,b,c arguments and calculated
	 * values x1, x2 of simple quadratic equation like ax^2 + bx + c = 0. If one of
	 * the arguments equals null result will be null.
	 * 
	 * @param calculationDto the data transfer object that contains necessary
	 * 		  arguments for simple quadratic equation a, b, and c
	 * @see   CalculationDto
	 * 
	 */
	public Calculation calculate(CalculationDto calculationDto);
}
