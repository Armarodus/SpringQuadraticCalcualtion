package quadratic.quadratic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "calc")
public class Calculation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Double avalue;

	@NotNull
	private Double bvalue;

	@NotNull
	private Double cvalue;
	
	@ElementCollection
	private List<Double> root = new ArrayList<>();

}
