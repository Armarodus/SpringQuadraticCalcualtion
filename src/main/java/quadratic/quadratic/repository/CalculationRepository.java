package quadratic.quadratic.repository;

import org.springframework.data.repository.CrudRepository;

import quadratic.quadratic.model.Calculation;

public interface CalculationRepository extends CrudRepository<Calculation, Long>{
	
}
