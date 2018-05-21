package rs.ac.uns.ftn.osa.news.dto;

import java.io.Serializable;

import rs.ac.uns.ftn.osa.news.entity.Tag;

@SuppressWarnings("serial")
public class TagDTO implements Serializable{
	
	private Long id;
	private String name;
	
	public TagDTO() {
		super();
	}
	
	public TagDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public TagDTO(Tag tag) {
		this(tag.getId(),
			tag.getName());
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
	
	
}
