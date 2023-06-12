package Enoca.demo.business.rules;

import org.springframework.stereotype.Service;

import Enoca.demo.business.core.utilities.exception.BusinessException;
import Enoca.demo.dataAccess.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {

	private CustomerRepository customerRepository;

	
	public void isValidCustomer(String name, int age) throws Exception {

		if (name.isEmpty()) {
			throw new BusinessException("Error: The name field is required.");
		}

		if (age < 18) {
			throw new BusinessException("Error: The age limit is 18.");
		}

	}
	
	public void checkIfCustomerNameExists(String name)throws Exception {

		if (!this.customerRepository.existsByNameIgnoreCase(name)) {

			throw new BusinessException("Customer already exists");
		}
	}

	public void isValidCustomerId(int id) throws Exception {

		if (!customerRepository.existsById(id)) {

			throw new Exception("Error: No registered user found.");
		}

	}

}
