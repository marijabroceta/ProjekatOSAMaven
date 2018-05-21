package rs.ac.uns.ftn.osa.news.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;


@SuppressWarnings("serial")
@Entity
@Table(name="post")
public class Post implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="title", unique=false, nullable=false)
	private String title;
	
	@Column(name="description",unique=false, nullable=false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="author_id", referencedColumnName="author_id",nullable=false)
	private User author;
	
	@Lob
	@Basic(fetch=LAZY)
	@Column(name="photo",unique=false,nullable=true)
	private byte[] photo;
	
	@Temporal(TIMESTAMP)
	@Column(name="post_date", unique=false, nullable=false)
	private Date date;
	
	@Column(name="likes", unique=false, nullable=false)
	private Integer likes;
	
	@Column(name="dislikes", unique=false, nullable=false)
	private Integer dislikes;
	
	@Column(name="longitude", unique=false, nullable=true)
	private float longitude;
	
	@Column(name="latitude", unique=false, nullable=true)
	private float latitude;
	
	@OneToMany(cascade={ALL}, fetch=LAZY, mappedBy="post" )
	private Set<Comment> comments = new HashSet<Comment>();
	
	@ManyToMany(cascade= {PERSIST,MERGE},fetch=LAZY)
	@JoinTable(name="post_tag",joinColumns=@JoinColumn(name = "post_id",referencedColumnName = "post_id"),inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName="tag_id"))
	private Set<Tag> tags = new HashSet<Tag>();
	
	

	public void add(Comment comment) {
		if(comment.getPost() != null) {
			comment.getPost().getComments().remove(comment);
		}
		comment.setPost(this);
		getComments().add(comment);
	}
	
	public void remove(Comment comment) {
		comment.setPost(null);
		getComments().remove(comment);
	}
	
	public void add(Tag tag) {
		tags.add(tag);
        tag.getPosts().add(this);
	}
	
	public void remove(Tag tag) {
        tags.remove(tag);
        tag.getPosts().remove(this);
    }
	
	public Post() {
		
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
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
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
	
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
}
