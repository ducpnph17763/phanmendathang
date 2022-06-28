package assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment.entities.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {
}
