package Enoca.demo.business.rules;

import org.springframework.stereotype.Service;

import Enoca.demo.business.core.utilities.exception.BusinessException;
import Enoca.demo.dataAccess.abstracts.OrderRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderBusinessRules {
	
	private OrderRepository orderRepository;

	public void isValidOrder(String createDate, double totalPrice) throws Exception {

		if (createDate.isEmpty()) {

			throw new BusinessException("Error: The createdate field is required !");
		}

		if (totalPrice <= 0) {

			throw new BusinessException("Error: Total Price please enter a valid amount !");
		}

	}

	public void isValidOrderId(int id) throws Exception {

		if (!orderRepository.existsById(id)) {

			throw new BusinessException("Error: No registered order found !");
		}

	}

}
