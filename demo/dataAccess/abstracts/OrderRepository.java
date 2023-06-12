package Enoca.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Enoca.demo.entities.concretes.Customer;
import Enoca.demo.entities.concretes.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

//	@Query(value = "from Order right join Customer on CustomerId = OrderId where OrderCustomerId Is Null ")
//	 List<Customer> findByOrdersCustomerIdIsNull();
}
