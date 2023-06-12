package Enoca.demo.webApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Enoca.demo.business.abstracts.CustomerService;
import Enoca.demo.business.requests.CreateCustomerRequest;
import Enoca.demo.business.requests.DeleteCustomerRequest;
import Enoca.demo.business.requests.UpdateCustomerRequest;
import Enoca.demo.business.responses.GetAllCustomerReponse;
import Enoca.demo.business.responses.GetCustomerByIdResponse;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {

		this.customerService = customerService;
	}

	@PostMapping(path = "/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) throws Exception {

		customerService.add(createCustomerRequest);

	}

	@DeleteMapping(path = "/delete")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@RequestBody @Valid DeleteCustomerRequest deleteCustomerRequest) throws Exception {

		customerService.delete(deleteCustomerRequest);
	}

	@PutMapping(path = "/update")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) throws Exception {

		customerService.update(updateCustomerRequest);
	}

	@GetMapping(path = "/getall")
	@ResponseStatus(code = HttpStatus.OK)
	public List<GetAllCustomerReponse> getAll() {

		return customerService.getAll();
	}

	@GetMapping(path = "/getbyid/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public GetCustomerByIdResponse getByIdResponse(@PathVariable(name = "id") @Valid int id) throws Exception {

		return customerService.getCustomerByIdResponse(id);
	}

}
