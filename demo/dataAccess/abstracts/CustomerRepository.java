package Enoca.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Enoca.demo.entities.concretes.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	  boolean existsByNameIgnoreCase(String name);
	
	 
}
