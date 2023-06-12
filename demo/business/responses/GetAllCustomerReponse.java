package Enoca.demo.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomerReponse {

	
	private int id;
	
	private String name;
	
	private int age;
}
