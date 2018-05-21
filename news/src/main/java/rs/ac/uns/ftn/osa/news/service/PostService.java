package rs.ac.uns.ftn.osa.news.service;

import java.util.List;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.osa.news.entity.Post;
import rs.ac.uns.ftn.osa.news.repository.PostRepository;

@Service
public class PostService implements PostServiceInterface{
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public Post findOne(Long postId) {
		return postRepository.getOne(postId);
	}
	
	@Override
	public List<Post> findAll(){
		return postRepository.findAll();
	}

	@Override
	public List<Post> findAllByOrderByDateDesc(){
		return postRepository.findAllByOrderByDateDesc();
	}


	
	@Override
	public List<Post> findByTags_Id(Long tagId){
		return postRepository.findByTags_Id(tagId);
	}
	
	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}
	
	@Override
	public void remove(Long id) {
		postRepository.deleteById(id);
	}
}
