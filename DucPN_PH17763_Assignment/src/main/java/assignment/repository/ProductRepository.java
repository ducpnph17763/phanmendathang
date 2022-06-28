package assignment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import assignment.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {
	public Page<Products> findBycategory_idEquals(Integer category_id, Pageable page);
}
