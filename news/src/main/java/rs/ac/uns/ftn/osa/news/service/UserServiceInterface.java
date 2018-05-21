package rs.ac.uns.ftn.osa.news.service;

import java.util.List;

import rs.ac.uns.ftn.osa.news.entity.User;

public interface UserServiceInterface {

	List<User> findAll();
	
	User findOne(Long userId);
	
	User findByUsernameAndPassword(String username,String password);
	
	User findByUsername(String username);
	
	User save(User user);
	
	void remove(Long id);
	
}
