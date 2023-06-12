package Enoca.demo.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderByIdResponse {

	private int id;

	private String createDate;

	private double totalPrice;
	
	private int customer_Id;
}
