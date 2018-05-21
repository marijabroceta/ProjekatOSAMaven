package rs.ac.uns.ftn.osa.news.dto;

import java.io.Serializable;
import java.util.Date;

import rs.ac.uns.ftn.osa.news.entity.Post;

@SuppressWarnings("serial")
public class PostDTO implements Serializable {

	private Long id;
	private String title;
	private String description;
	private byte[] photo;
	private Date date;
	private Integer likes;
	private Integer dislikes;
	private float longitude;
	private float latitude;
	private UserDTO author;
	
	public PostDTO() {
		super();
	}
	
	public PostDTO(Long id, String title, String description, byte[] photo, Date date, Integer likes, Integer dislikes,
			float longitude, float latitude, UserDTO author) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.date = date;
		this.likes = likes;
		this.dislikes = dislikes;
		this.longitude = longitude;
		this.latitude = latitude;
		this.author = author;
	}

	public PostDTO(Post post) {
		this(post.getId(),
			post.getTitle(),
			post.getDescription(),
			post.getPhoto(),
			post.getDate(),
			post.getLikes(),
			post.getDislikes(),
			post.getLongitude(),
			post.getLatitude(),
			new UserDTO(post.getAuthor()));
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
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public UserDTO getAuthor() {
		return author;
	}
	public void setAuthor(UserDTO author) {
		this.author = author;
	}
	
	
	
}
