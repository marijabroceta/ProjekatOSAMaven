package rs.ac.uns.ftn.osa.news.service;

import java.util.List;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.osa.news.entity.Post;
import rs.ac.uns.ftn.osa.news.entity.User;
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
	public List<Post> findAllByOrderByLikes() {
		return postRepository.findAllByOrderByLikes();
	}

	@Override
	public List<Post> findAllByOrderByDislikes() {
		return postRepository.findAllByOrderByDislikes();
	}

	@Override
	public List<Post> findByAuthor(User user) {
		return postRepository.findByAuthor(user);
	}


	@Override
	public List<Post> findAll(Sort sort) {
		return postRepository.findAll(sort);
	}


	@Override
	public List<Post> findByTags_Id(Long tagId){
		return postRepository.findByTags_Id(tagId);
	}

	@Override
	public List<Post> findByTags_Name(String name) {
		return postRepository.findByTags_Name(name);
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
