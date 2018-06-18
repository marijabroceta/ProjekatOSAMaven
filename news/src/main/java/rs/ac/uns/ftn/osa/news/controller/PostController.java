package rs.ac.uns.ftn.osa.news.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.geometry.Pos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;
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
import rs.ac.uns.ftn.osa.news.service.CommentService;
import rs.ac.uns.ftn.osa.news.service.PostServiceInterface;
import rs.ac.uns.ftn.osa.news.service.TagServiceInterface;
import rs.ac.uns.ftn.osa.news.service.UserServiceInterface;

@RestController
@RequestMapping(value="api/posts")
public class PostController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

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
		LOGGER.debug("Lista postova");
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

	@GetMapping(value="/searchbyauthor/{username}")
	public ResponseEntity<List<PostDTO>> searchByAuthor(@PathVariable("username") String username){
		List<Post> postByAuthor = postService.findByAuthor(userService.findByUsername(username));

		List<PostDTO> postsDTO = new ArrayList<PostDTO>();
		for(Post p:postByAuthor) {
			System.out.println(p.getAuthor().getName());
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO,HttpStatus.OK);
	}

	@GetMapping(value="/tags/{name}")
	public ResponseEntity<List<PostDTO>> searchByTag(@PathVariable("name") String name){
		List<Post> postByTagSearch = postService.findByTags_Name(name);

		List<PostDTO> postsDTO = new ArrayList<PostDTO>();
		for(Post p:postByTagSearch) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO,HttpStatus.OK);
	}

	@GetMapping(value="/sort/bydate")
	public ResponseEntity<List<PostDTO>> getPostsSorted(){
		List<Post> posts = postService.findAllByOrderByDateDesc();
		List<PostDTO> postsDTO = new ArrayList<PostDTO>();
		for(Post p:posts) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
	}

	@GetMapping(value="/sort/bycomments")
	public ResponseEntity<List<PostDTO>> getPostsSortedCom(){
		List<Post> posts = postService.findAll();
		List<PostDTO> postsDTO = new ArrayList<PostDTO>();

		Collections.sort(posts, new Comparator<Post>() {
			@Override
			public int compare(Post o1, Post o2) {
				return o1.getComments().size() - o2.getComments().size();
			}
		});
		for(Post p:posts) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/sort/bylikes")
	public ResponseEntity<List<PostDTO>> getPostsSortByLikes(){
		List<Post> posts = postService.findAllByOrderByLikes();
		List<PostDTO> postsDTO = new ArrayList<>();
		for(Post p:posts){
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO,HttpStatus.OK);
	}

	@GetMapping(value="/sort/bydislikes")
	public ResponseEntity<List<PostDTO>> getPostsSortByDisikes(){
		List<Post> posts = postService.findAllByOrderByDislikes();
		List<PostDTO> postsDTO = new ArrayList<>();
		for(Post p:posts){
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO,HttpStatus.OK);
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
	
	@PutMapping(value="/setTags/{postId}/{tagId}")
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
