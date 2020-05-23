package matheus.io.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import matheus.io.projeto1.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
	User findByEmail(String email);
	
	@Query("SELECT u FROM User as u WHERE u.name like %?1% ")
	User findByNameThatHasAStringInTheMiddle(String name);
}
