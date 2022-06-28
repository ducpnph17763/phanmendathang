package assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import assignment.entities.OrderDetails;

public interface OrderDetailRepository extends JpaRepository<OrderDetails, Integer> {

}
