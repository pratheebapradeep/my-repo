package dao;

import java.util.List;

import model.User;

public interface User_DAO {
	public boolean saveUser(User user);
	public List<User> getUsers();
	public boolean deleteUser(User user);
	public List<User> getUserByID(User user);
	public boolean updateUser(User user);
}