package rs.ac.uns.ftn.osa.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.osa.news.entity.User;
import rs.ac.uns.ftn.osa.news.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findOne(Long userId) {
		return userRepository.getOne(userId);
	}
	
	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	public User findByUsernameAndPassword(String username,String password) {
		return userRepository.findByUsernameAndPassword(username,password);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void remove(Long id) {
		userRepository.deleteById(id);
	}
}
