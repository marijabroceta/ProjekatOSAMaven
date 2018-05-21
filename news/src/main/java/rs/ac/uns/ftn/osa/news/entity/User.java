package rs.ac.uns.ftn.osa.news.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@SuppressWarnings("serial")
@Entity
@Table(name="users")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="author_id",unique=true,nullable=false)
	private Long id;
	
	@Column(name="name",unique=false,nullable = false)
	private String name;
	
	@Column(name="username",unique=true,nullable=false)
	private String username;
	
	@Column(name="password",unique=true,nullable=false)
	private String password;
	
	@Column(name="photo_user",unique=false,nullable=true)
	private byte[] photo_user;
	
	@OneToMany(cascade={ALL}, fetch=LAZY, mappedBy="author")
	private Set<Post> posts = new HashSet<Post>();
	
	@OneToMany(cascade={ALL}, fetch=LAZY, mappedBy="author")
	private Set<Comment> comments = new HashSet<Comment>();
	
	public void add(Post post) {
		if(post.getAuthor() != null) {
			post.getAuthor().getPosts().remove(post);
		}
		post.setAuthor(this);
		getPosts().add(post);
	}
	
	public void add(Comment comment) {
		if(comment.getAuthor() != null) {
			comment.getAuthor().getComments().remove(comment);
		}
		comment.setAuthor(this);
		getComments().add(comment);
	}
	
	public void remove(Post post) {
		post.setAuthor(null);
		getPosts().remove(post);
	}
	
	public void remove(Comment comment) {
		comment.setAuthor(null);
		getComments().remove(comment);
	}
	
	public User() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public byte[] getPhoto_user() {
		return photo_user;
	}
	public void setPhoto_user(byte[] photo_user) {
		this.photo_user = photo_user;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
}
