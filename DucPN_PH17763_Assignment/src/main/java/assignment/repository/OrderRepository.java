package assignment.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import assignment.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
	public Orders findBystatusEquals(Integer sta);
	
//	@Query("SELECT x FROM Orders x WHERE x.status=:id")
//	public List<Orders> findLS(@Param("id") Integer id);

	public Page<Orders> findBystatusEquals(Integer sta, Pageable page);
}
