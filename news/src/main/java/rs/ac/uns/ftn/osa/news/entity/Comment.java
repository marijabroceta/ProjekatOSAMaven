package rs.ac.uns.ftn.osa.news.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="comment")
public class Comment implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id",unique = true,nullable=false)
	private Long id;
	
	@Column(name="comm_title",unique=false,nullable=true)
	private String title;
	
	@Column(name="comm_description",unique=false,nullable=true)
	private String description;
	
	@Column(name="comm_date",unique=false,nullable=false)
	private Date date;
	
	@Column(name="comm_likes",unique=false,nullable=false)
	private Integer likes;
	
	@Column(name="comm_dislikes",unique=false,nullable=false)
	private Integer dislikes;
	
	@ManyToOne
	@JoinColumn(name="post_id",referencedColumnName="post_id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="author_id",referencedColumnName="author_id")
	private User author;
	
	
	public Comment() {
		
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
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	
}
