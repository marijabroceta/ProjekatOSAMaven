package rs.ac.uns.ftn.osa.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.osa.news.entity.Comment;
import rs.ac.uns.ftn.osa.news.entity.Post;
import rs.ac.uns.ftn.osa.news.repository.CommentRepository;


@Service
public class CommentService implements CommentServiceInterface{

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public Comment findOne(Long commentId) {
		return commentRepository.getOne(commentId);
	}
	
	@Override
	public List<Comment> findAll(){
		return commentRepository.findAll();
	}
	
	@Override
	public List<Comment> findByPost(Post post){
		return commentRepository.findByPost(post);
	}
	
	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}
	
	@Override
	public void remove(Long id) {
		commentRepository.deleteById(id);
	}
		
}
