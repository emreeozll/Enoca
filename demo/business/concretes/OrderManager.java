package Enoca.demo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Enoca.demo.business.abstracts.OrderService;
import Enoca.demo.business.core.utilities.mappers.ModelMapperService;
import Enoca.demo.business.requests.CreateOrderRequest;
import Enoca.demo.business.requests.DeleteOrderRequest;
import Enoca.demo.business.requests.UpdateOrderRequest;
import Enoca.demo.business.responses.GetAllOrderResponse;
import Enoca.demo.business.responses.GetOrderByIdResponse;
import Enoca.demo.business.rules.OrderBusinessRules;
import Enoca.demo.dataAccess.abstracts.OrderRepository;
import Enoca.demo.entities.concretes.Customer;
import Enoca.demo.entities.concretes.Order;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

	private OrderRepository orderRepository;
	private ModelMapperService modelMapperService;
	private OrderBusinessRules orderBusinessRules;


	@Override
	public void add(CreateOrderRequest createOrderRequest) throws Exception {

		this.orderBusinessRules.isValidOrder(createOrderRequest.getCreateDate(), createOrderRequest.getTotalPrice());

		Order order = this.modelMapperService.forRequest().map(createOrderRequest, Order.class);
		this.orderRepository.save(order);

	}

	@Override
	public void delete(DeleteOrderRequest deleteOrderRequest) throws Exception {

		this.orderBusinessRules.isValidOrderId(deleteOrderRequest.getId());

		Order order = orderRepository.findById(deleteOrderRequest.getId()).orElseThrow();
		orderRepository.delete(order);

	}

	@Override
	public void update(UpdateOrderRequest updateOrderRequest) throws Exception {

		this.orderBusinessRules.isValidOrder(updateOrderRequest.getCreateDate(), updateOrderRequest.getTotalPrice());
		this.orderBusinessRules.isValidOrderId(updateOrderRequest.getId());

		Order order = this.modelMapperService.forRequest().map(updateOrderRequest, Order.class);
		this.orderRepository.save(order);

	}

	@Override
	public List<GetAllOrderResponse> getAll() {

		List<Order> orders = orderRepository.findAll();

		List<GetAllOrderResponse> allOrderResponses = orders.stream()
				.map(order -> this.modelMapperService.forResponse().map(order, GetAllOrderResponse.class))
				.collect(Collectors.toList());

		return allOrderResponses;

	}

	@Override
	public GetOrderByIdResponse getOrderByIdResponse(int id) throws Exception {

		Order order = this.orderRepository.findById(id).orElseThrow();

		GetOrderByIdResponse orderByIdResponse = this.modelMapperService.forResponse().map(order,
				GetOrderByIdResponse.class);
		return orderByIdResponse;
	}

//	@Override
//	public List<Customer> getCustomersWithoutOrders() {
//		
//		return orderRepository.findByOrdersCustomerIdIsNull();
//	}



}
