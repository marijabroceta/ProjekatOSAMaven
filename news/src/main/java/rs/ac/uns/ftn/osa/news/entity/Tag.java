package rs.ac.uns.ftn.osa.news.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tag")
public class Tag implements Serializable{
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="tag_id",unique=true,nullable=false)
	private Long id;
	
	@Column(name="tag_name",unique=false,nullable=false)
	private String name;
	
	@ManyToMany(mappedBy = "tags",fetch=LAZY)
	private Set<Post> posts = new HashSet<Post>();
	
	public Tag() {
		
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
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	
}
