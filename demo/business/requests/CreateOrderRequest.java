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
public class CreateOrderRequest {

	
	@NotBlank
	@NotEmpty
	private String createDate;
	@NotNull
	private double totalPrice;
	@NotNull
	private int customer_Id;
	
}
