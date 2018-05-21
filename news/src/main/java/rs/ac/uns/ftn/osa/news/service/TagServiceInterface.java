package rs.ac.uns.ftn.osa.news.service;

import java.util.List;


import rs.ac.uns.ftn.osa.news.entity.Tag;

public interface TagServiceInterface {

	List<Tag> findAll();
	
	Tag findOne(Long tagId);

	Tag findByName(String name);
	
	List<Tag> findByPosts_Id(Long postId); 
	
	Tag save(Tag tag);
	
	void remove(Long id);
}
