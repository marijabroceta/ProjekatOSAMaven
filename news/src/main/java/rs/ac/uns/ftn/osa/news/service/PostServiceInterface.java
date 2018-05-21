package rs.ac.uns.ftn.osa.news.service;

import java.util.List;

import javafx.geometry.Pos;
import rs.ac.uns.ftn.osa.news.entity.Post;


public interface PostServiceInterface {

	List<Post> findAll();
	
	Post findOne(Long postId);

	List<Post> findAllByOrderByDateDesc();
	
	List<Post> findByTags_Id(Long tagId); 
	
	Post save(Post post);
	
	void remove(Long id);
}
