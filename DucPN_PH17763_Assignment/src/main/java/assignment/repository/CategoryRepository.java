package assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import assignment.entities.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Integer>{

}
