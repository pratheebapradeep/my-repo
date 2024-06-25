package cotroller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import service.User_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class Controller {
	
	@Autowired
	private User_Service userservice;
	
	@PostMapping("save-user")
	public boolean saveUser(@RequestBody User user) {
		 return userservice.saveUser(user);
		
	}
	
	@GetMapping("users-list")
	public List<User> allUsers() {
		 return userservice.getUsers();
	}
	
	
	@DeleteMapping("delete-user/{id}")
	public boolean deleteUser(@PathVariable("user_id") int id,User user) {
		user.setId(id);
		return userservice.deleteUser(user);
	}

	@GetMapping("user/{id}")
	public List<User> userByID(@PathVariable("id") int id,User user) {
		 user.setId(id);
		 return userservice.getUserByID(user);		
	}
	
	@PostMapping("update-user/{id}")
	public boolean updateUser(@RequestBody User user,@PathVariable("id") int id) {
		user.setId(id);
		return userservice.updateUser(user);
	}
}