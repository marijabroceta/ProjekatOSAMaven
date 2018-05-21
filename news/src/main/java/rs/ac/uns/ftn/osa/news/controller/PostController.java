package rs.ac.uns.ftn.osa.news.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import rs.ac.uns.ftn.osa.news.dto.PostDTO;

import rs.ac.uns.ftn.osa.news.entity.Post;
import rs.ac.uns.ftn.osa.news.entity.Tag;
import rs.ac.uns.ftn.osa.news.service.PostServiceInterface;
import rs.ac.uns.ftn.osa.news.service.TagServiceInterface;
import rs.ac.uns.ftn.osa.news.service.UserServiceInterface;

@RestController
@RequestMapping(value="api/posts")
public class PostController {

	@Autowired
	private PostServiceInterface postService;
	
	@Autowired 
	private UserServiceInterface userService;
	
	@Autowired
	private TagServiceInterface tagService;
	
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> getPosts(){
		List<Post> posts = postService.findAll();
		List<PostDTO> postsDTO = new ArrayList<PostDTO>();
		for(Post p:posts) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PostDTO> getPost(@PathVariable("id") Long id){
		Post post = postService.findOne(id);
		if(post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PostDTO>(new PostDTO(post),HttpStatus.OK);
	}
	
	@GetMapping(value="/tag/{id}")
	public ResponseEntity<List<PostDTO>> getPostByTag(@PathVariable("id") Long id){
		List<Post> postByTag = postService.findByTags_Id(id);
		
		List<PostDTO> postsDTO = new ArrayList<PostDTO>();
		for(Post p:postByTag) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO,HttpStatus.OK);
	}

	@GetMapping(value="/sortByDate")
	public ResponseEntity<List<PostDTO>> getPostsSorted(){
		List<Post> posts = postService.findAllByOrderByDateDesc();
		List<PostDTO> postsDTO = new ArrayList<PostDTO>();
		for(Post p:posts) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
	}
	
	
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO){
		Post post = new Post();
		
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setDate(postDTO.getDate());
		post.setLikes(postDTO.getLikes());
		post.setDislikes(postDTO.getDislikes());
		post.setPhoto(postDTO.getPhoto());
		post.setLongitude(postDTO.getLongitude());
		post.setLatitude(postDTO.getLatitude());
		post.setAuthor(userService.findOne(postDTO.getAuthor().getId()));
		
		
		
		
		post = postService.save(post);
		return new ResponseEntity<PostDTO>(new PostDTO(post),HttpStatus.CREATED);
	}
	
	@PutMapping(value="/setTags/{postId}/{tagId}",consumes = "application/json")
	public ResponseEntity<PostDTO> setTagsInPost(@PathVariable("postId") Long postId,@PathVariable("tagId") Long tagId){
		Post post = postService.findOne(postId);
		Tag tag = tagService.findOne(tagId);
		
		if(post == null || tag == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.BAD_REQUEST);
		}
		
		post.getTags().add(tag);
		tag.getPosts().add(post);
		
		
		post = postService.save(post);
		tag = tagService.save(tag);
		return new ResponseEntity<PostDTO>(new PostDTO(post),HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}",consumes="application/json")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO,@PathVariable("id") Long id){
		Post post = postService.findOne(id);
		
		if(post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.BAD_REQUEST);
		}
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setDate(postDTO.getDate());
		post.setLikes(postDTO.getLikes());
		post.setDislikes(postDTO.getDislikes());
		post.setPhoto(postDTO.getPhoto());
		post.setLongitude(postDTO.getLongitude());
		post.setLatitude(postDTO.getLatitude());
		post.setAuthor(userService.findOne(postDTO.getId()));
		
		post = postService.save(post);
		
		return new ResponseEntity<PostDTO>(new PostDTO(post),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable Long id){
		Post post = postService.findOne(id);
		if(post != null) {
			postService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
