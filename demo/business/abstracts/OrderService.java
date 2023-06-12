package Enoca.demo.business.abstracts;

import java.util.List;

import Enoca.demo.business.requests.CreateOrderRequest;
import Enoca.demo.business.requests.DeleteOrderRequest;
import Enoca.demo.business.requests.UpdateOrderRequest;
import Enoca.demo.business.responses.GetAllOrderResponse;
import Enoca.demo.business.responses.GetOrderByIdResponse;
import Enoca.demo.entities.concretes.Customer;

public interface OrderService {

	public void add(CreateOrderRequest createOrderRequest) throws Exception;

	public  void delete(DeleteOrderRequest deleteOrderRequest) throws Exception;

	public  void update(UpdateOrderRequest updateOrderRequest) throws Exception;

	public  List<GetAllOrderResponse> getAll();

	GetOrderByIdResponse getOrderByIdResponse(int id) throws Exception;
	
//	public List<Customer> getCustomersWithoutOrders();
	
}
