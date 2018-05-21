package rs.ac.uns.ftn.osa.news.dto;

import java.io.Serializable;
import java.util.Date;

import rs.ac.uns.ftn.osa.news.entity.Comment;


@SuppressWarnings("serial")
public class CommentDTO implements Serializable{

	private Long id;
	private String title;
	private String description;
	private Date date;
	private Integer likes;
	private Integer dislikes;
	private PostDTO post;
	private UserDTO author;
	
	
	public CommentDTO() {
		super();
	}
	
	
	
	public CommentDTO(Long id, String title, String description, Date date, Integer likes, Integer dislikes, PostDTO post,
			UserDTO author) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.likes = likes;
		this.dislikes = dislikes;
		this.post = post;
		this.author = author;
	}

	public CommentDTO(Comment comment) {
		this(comment.getId(),
			comment.getTitle(),
			comment.getDescription(),
			comment.getDate(),
			comment.getLikes(),
			comment.getDislikes(),
			new PostDTO(comment.getPost()),
			new UserDTO(comment.getAuthor()));
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Integer getLikes() {
		return likes;
	}



	public void setLikes(Integer likes) {
		this.likes = likes;
	}



	public Integer getDislikes() {
		return dislikes;
	}



	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}



	public PostDTO getPost() {
		return post;
	}



	public void setPost(PostDTO post) {
		this.post = post;
	}



	public UserDTO getAuthor() {
		return author;
	}



	public void setAuthor(UserDTO author) {
		this.author = author;
	}

	
	
}
