package Enoca.demo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Enoca.demo.business.abstracts.CustomerService;
import Enoca.demo.business.core.utilities.mappers.ModelMapperService;
import Enoca.demo.business.requests.CreateCustomerRequest;
import Enoca.demo.business.requests.DeleteCustomerRequest;
import Enoca.demo.business.requests.UpdateCustomerRequest;
import Enoca.demo.business.responses.GetAllCustomerReponse;
import Enoca.demo.business.responses.GetCustomerByIdResponse;
import Enoca.demo.business.rules.CustomerBusinessRules;
import Enoca.demo.dataAccess.abstracts.CustomerRepository;
import Enoca.demo.entities.concretes.Customer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

	private CustomerRepository customerRepository;
	private CustomerBusinessRules customerBusinessRules;
	private ModelMapperService modelMapperService;

	@Override
	public void add(CreateCustomerRequest createCustomerRequest) throws Exception {

		this.customerBusinessRules.isValidCustomer(createCustomerRequest.getName(), createCustomerRequest.getAge());
		this.customerBusinessRules.checkIfCustomerNameExists(createCustomerRequest.getName());;

		Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
	}

	@Override
	public void delete(DeleteCustomerRequest deleteCustomerRequest) throws Exception {

		this.customerBusinessRules.isValidCustomerId(deleteCustomerRequest.getId());

		Customer customer = customerRepository.getReferenceById(deleteCustomerRequest.getId());
		customerRepository.delete(customer);

	}

	@Override
	public void update(UpdateCustomerRequest updateCustomerRequest) throws Exception {

		this.customerBusinessRules.isValidCustomerId(updateCustomerRequest.getId());
		this.customerBusinessRules.isValidCustomer(updateCustomerRequest.getName(), updateCustomerRequest.getAge());

		Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
		customerRepository.save(customer);

	}

	@Override
	public List<GetAllCustomerReponse> getAll() {

		List<Customer> customers = customerRepository.findAll();

		List<GetAllCustomerReponse> allCustomerReponses = customers.stream()
				.map(customer -> this.modelMapperService.forResponse().map(customer, GetAllCustomerReponse.class))
				.collect(Collectors.toList());

		return allCustomerReponses;

	}

	@Override
	public GetCustomerByIdResponse getCustomerByIdResponse(int id) throws Exception {

		Customer customer = this.customerRepository.findById(id).orElseThrow();

		GetCustomerByIdResponse byIdResponse = this.modelMapperService.forResponse().map(customer,
				GetCustomerByIdResponse.class);
		return byIdResponse;

	}

}
