package Enoca.demo.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

	
	@NotNull
	private int id;
	
	@NotEmpty
	@NotBlank
	private String name;
	
	@NotNull
	private int age;
}
