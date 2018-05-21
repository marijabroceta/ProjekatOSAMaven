package rs.ac.uns.ftn.osa.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import rs.ac.uns.ftn.osa.news.entity.Tag;
import rs.ac.uns.ftn.osa.news.repository.TagRepository;

@Service
public class TagService implements TagServiceInterface{

	@Autowired
	TagRepository tagRepository;
	
	@Override
	public Tag findOne(Long tagId) {
		return tagRepository.getOne(tagId);
	}
	
	@Override
	public List<Tag> findAll(){
		return tagRepository.findAll();
	}

	@Override
	public Tag findByName(String name){
		return tagRepository.findByName(name);
	}
	
	@Override
	public List<Tag> findByPosts_Id(Long postId){
		return tagRepository.findByPosts_Id(postId);
	}
	
	@Override
	public Tag save(Tag tag) {
		return tagRepository.save(tag);
	}
	
	@Override 
	public void remove(Long id) {
		tagRepository.deleteById(id);
	}
	
	
}
