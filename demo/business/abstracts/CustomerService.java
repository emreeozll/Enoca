package Enoca.demo.business.abstracts;

import java.util.List;

import Enoca.demo.business.requests.CreateCustomerRequest;
import Enoca.demo.business.requests.DeleteCustomerRequest;
import Enoca.demo.business.requests.UpdateCustomerRequest;
import Enoca.demo.business.responses.GetAllCustomerReponse;
import Enoca.demo.business.responses.GetCustomerByIdResponse;

public interface CustomerService {

	public void add(CreateCustomerRequest createCustomerRequest) throws Exception;

	public void delete(DeleteCustomerRequest deleteCustomerRequest) throws Exception;

	public void update(UpdateCustomerRequest updateCustomerRequest) throws Exception;

	public List<GetAllCustomerReponse> getAll();

	GetCustomerByIdResponse getCustomerByIdResponse(int id) throws Exception;

	

}
