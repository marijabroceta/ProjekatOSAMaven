package rs.ac.uns.ftn.osa.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.osa.news.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);

}
