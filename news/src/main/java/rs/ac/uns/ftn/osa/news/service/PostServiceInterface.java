package rs.ac.uns.ftn.osa.news.service;

import java.util.List;

import javafx.geometry.Pos;
import org.springframework.data.domain.Sort;
import rs.ac.uns.ftn.osa.news.entity.Post;
import rs.ac.uns.ftn.osa.news.entity.User;


public interface PostServiceInterface {

	List<Post> findAll();
	
	Post findOne(Long postId);

	List<Post> findAllByOrderByDateDesc();

	List<Post> findAllByOrderByLikes();

	List<Post> findAllByOrderByDislikes();

	List<Post> findByAuthor(User user);

	List<Post> findAll(Sort sort);

	List<Post> findByTags_Id(Long tagId);

	List<Post> findByTags_Name(String name);
	
	Post save(Post post);
	
	void remove(Long id);
}
