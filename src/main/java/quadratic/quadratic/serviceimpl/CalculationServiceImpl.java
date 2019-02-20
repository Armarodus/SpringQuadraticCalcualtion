package quadratic.quadratic.serviceimpl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quadratic.quadratic.model.Calculation;
import quadratic.quadratic.repository.CalculationRepository;
import quadratic.quadratic.service.CalculationService;
@Service
public class CalculationServiceImpl implements CalculationService {

	private static Logger log = LoggerFactory.getLogger(CalculationServiceImpl.class);
	
	@Autowired
	private CalculationRepository calcRepo;
	
	@Override
	public Calculation calculate(Calculation calculation) {
		Double firstX;
		Double secondX;
		Double discriminant = Math.pow(calculation.getBvalue(), 2)
				- 4 * calculation.getAvalue() * calculation.getCvalue();
		log.info("DISCRIMINANT: {}",discriminant);
		if (discriminant > 0) {
			firstX = (-calculation.getBvalue()+Math.sqrt(discriminant))/(2*calculation.getAvalue());
			secondX = (-calculation.getBvalue()-Math.sqrt(discriminant))/(2*calculation.getAvalue());
			calculation.getRoot().addAll(Arrays.asList(firstX,secondX));
		}
		else if (discriminant == 0) {
			firstX = (-calculation.getBvalue())/(2*calculation.getAvalue());
			calculation.getRoot().add(firstX);
		}
		
		calcRepo.save(calculation);
		return calculation;
	}


}
