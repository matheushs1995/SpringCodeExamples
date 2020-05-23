package matheus.io.projeto1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import matheus.io.projeto1.entity.User;
import matheus.io.projeto1.repository.UserRepository;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		// firstExample_CreateUsers();
		// secondExample_UpdateUserName_ID(1L, "Nataniel Barros");
		// thirdExample_DeleteUser_SameID(3L);

	}

	public void firstExample_CreateUsers() {
		createUser("Nataniel", "nataniel.paiva@gmail.com");
		createUser("João", "joao@gmail.com");
		createUser("Maria", "maria@gmail.com");
	}

	public void createUser(String name, String email) {

		User user = new User(name, email);

		userRepository.save(user);

	}

	public void secondExample_UpdateUserName_SameID(Long id, String newName) {

		User user = userRepository.getOne(id);

		user.setName(newName);

		userRepository.save(user);
	}

	public void thirdExample_DeleteUser_SameID(Long id) {

		userRepository.deleteById(id);

	}

	public User findUser_SameName(String name) {

		User user = userRepository.findByName(name);
		return user;
	}
	
	public User findUser_SameEmail(String email) {

		User user = userRepository.findByEmail(email);
		return user;
	}

	public User findUser_SameName_ThatHasAStringInTheMiddle(String name) {

		User user = userRepository.findByNameThatHasAStringInTheMiddle(name);
		return user;
	}
	
	

}
