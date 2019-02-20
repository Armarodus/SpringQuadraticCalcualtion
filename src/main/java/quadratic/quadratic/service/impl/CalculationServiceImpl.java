package quadratic.quadratic.service.impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quadratic.quadratic.model.Calculation;
import quadratic.quadratic.model.dto.CalculationDto;
import quadratic.quadratic.repository.CalculationRepository;
import quadratic.quadratic.service.CalculationService;
@Service
public class CalculationServiceImpl implements CalculationService {

	private static Logger log = LoggerFactory.getLogger(CalculationServiceImpl.class);
	
	@Autowired
	private CalculationRepository calcRepo;
	
	@Override
	public Calculation calculate(CalculationDto calculationDto) {
		
		if (calculationDto.getAvalue() == null || calculationDto.getBvalue() == null || calculationDto.getCvalue() == null) {
			return null;
		}
		
		Calculation calc = new Calculation(calculationDto.getAvalue(),calculationDto.getBvalue(),calculationDto.getCvalue());
		Double firstX;
		Double secondX;
		Double discriminant = Math.pow(calculationDto.getBvalue(), 2)
				- 4 * calculationDto.getAvalue() * calculationDto.getCvalue();
		
		if (discriminant > 0) {
			firstX = (-calculationDto.getBvalue()+Math.sqrt(discriminant))/(2*calculationDto.getAvalue());
			secondX = (-calculationDto.getBvalue()-Math.sqrt(discriminant))/(2*calculationDto.getAvalue());
			firstX = Math.round(firstX * 100.0) / 100.0;
			secondX = Math.round(secondX * 100.0) / 100.0;
			calc.getRoot().addAll(Arrays.asList(firstX,secondX));
		}
		else if (discriminant == 0) {
			firstX = (-calculationDto.getBvalue())/(2*calculationDto.getAvalue());
			calc.getRoot().add(firstX);
		}
		
		calcRepo.save(calc);
		return calc;
	}


}
