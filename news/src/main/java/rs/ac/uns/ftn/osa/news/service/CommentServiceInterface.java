package rs.ac.uns.ftn.osa.news.service;

import java.util.List;

import rs.ac.uns.ftn.osa.news.entity.Comment;
import rs.ac.uns.ftn.osa.news.entity.Post;


public interface CommentServiceInterface {

	List<Comment> findAll();
	
	Comment findOne(Long commentId);
	
	List<Comment> findByPost(Post post);
	
	Comment save(Comment comment);
	
	void remove(Long id);
	
}
