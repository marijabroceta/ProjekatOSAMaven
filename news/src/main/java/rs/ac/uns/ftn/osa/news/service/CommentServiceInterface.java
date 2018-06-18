package rs.ac.uns.ftn.osa.news.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import rs.ac.uns.ftn.osa.news.entity.Comment;
import rs.ac.uns.ftn.osa.news.entity.Post;


public interface CommentServiceInterface {

	List<Comment> findAll();
	
	Comment findOne(Long commentId);
	
	List<Comment> findByPost(Post post);

	List<Comment> findAllByOrderByDateDesc();

	List<Comment> findAllByOrderByLikesDesc();

	List<Comment> findAllByOrderByDislikesDesc();

	List<Comment> findByPost(Post post,Sort sort);

	Comment save(Comment comment);
	
	void remove(Long id);
	
}
