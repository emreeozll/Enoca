package Enoca.demo.webApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Enoca.demo.business.abstracts.OrderService;
import Enoca.demo.business.requests.CreateOrderRequest;
import Enoca.demo.business.requests.DeleteOrderRequest;
import Enoca.demo.business.requests.UpdateOrderRequest;
import Enoca.demo.business.responses.GetAllOrderResponse;
import Enoca.demo.business.responses.GetOrderByIdResponse;
import Enoca.demo.entities.concretes.Customer;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	private OrderService orderService;

	@Autowired
	public OrdersController(OrderService orderService) {

		this.orderService = orderService;
	}

	@PostMapping(path = "/add")
	public void add(@RequestBody @Valid CreateOrderRequest createOrderRequest) throws Exception {

		orderService.add(createOrderRequest);
	}

	@DeleteMapping(path = "/delete")
	public void delete(@RequestBody @Valid DeleteOrderRequest deleteOrderRequest) throws Exception {

		orderService.delete(deleteOrderRequest);
	}

	@PutMapping(path = "/update")
	public void update (@RequestBody @Valid UpdateOrderRequest updateOrderRequest) throws Exception {

		orderService.update(updateOrderRequest);
	}

	@GetMapping(path = "/getall")
	public List<GetAllOrderResponse> getAll() {

		return orderService.getAll();
	}

	@GetMapping(path = "/getbyid/{id}")
	public GetOrderByIdResponse getOrderByIdResponse(@PathVariable(name = "id") @Valid int id) throws Exception {

		return orderService.getOrderByIdResponse(id);
	}

//	@GetMapping(path = "/getcustomerswithoutorders")
//     public List<Customer> getCustomersWithoutOrders() {
//		
//		return orderService.getCustomersWithoutOrders();
//	}


   
}
