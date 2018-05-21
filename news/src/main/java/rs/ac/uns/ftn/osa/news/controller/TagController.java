package rs.ac.uns.ftn.osa.news.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import rs.ac.uns.ftn.osa.news.dto.TagDTO;

import rs.ac.uns.ftn.osa.news.entity.Tag;
import rs.ac.uns.ftn.osa.news.service.TagServiceInterface;


@RestController
@RequestMapping(value="api/tags")
public class TagController {

	@Autowired
	private TagServiceInterface tagService;
	
	
	@GetMapping
	public ResponseEntity<List<TagDTO>> getTags(){
		List<Tag> tags = tagService.findAll();
		
		List<TagDTO> tagsDTO = new ArrayList<TagDTO>();
		for(Tag t : tags) {
			tagsDTO.add(new TagDTO(t));
		}
		return new ResponseEntity<List<TagDTO>>(tagsDTO,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<TagDTO> getTag(@PathVariable("id") Long id){
		Tag tag = tagService.findOne(id);
		if(tag == null) {
			return new ResponseEntity<TagDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TagDTO>(new TagDTO(tag), HttpStatus.OK);
	}
	
	@GetMapping(value="/getName/{name}")
	public ResponseEntity<TagDTO> getTagByName(@PathVariable("name") String name){
		Tag tag = tagService.findByName(name);
		if(tag == null) {
			return new ResponseEntity<TagDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TagDTO>(new TagDTO(tag),HttpStatus.OK);
	}
	
	@GetMapping(value="/post/{id}")
	public ResponseEntity<List<TagDTO>> getTagByPost(@PathVariable("id") Long id){
		List<Tag> tagsByPost = tagService.findByPosts_Id(id);
		
		List<TagDTO> tagsDTO = new ArrayList<TagDTO>();
		for(Tag t:tagsByPost) {
			tagsDTO.add(new TagDTO(t));
		}
		return new ResponseEntity<List<TagDTO>>(tagsDTO,HttpStatus.OK);
		
		
	}
	
	
	
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<TagDTO> saveTag(@RequestBody TagDTO tagDTO){
		Tag tag = new Tag();
		tag.setName(tagDTO.getName());
		
		tag = tagService.save(tag);
		return new ResponseEntity<TagDTO>(new TagDTO(tag),HttpStatus.OK);
	}
	

	
	@PutMapping(value="/{id}",consumes="application/json")
	public ResponseEntity<TagDTO> updateTag(@RequestBody TagDTO tagDTO,@PathVariable("id") Long id){
		Tag tag = tagService.findOne(id);
		
		if(tag == null) {
			return new ResponseEntity<TagDTO>(HttpStatus.BAD_REQUEST);
		}
		
		tag.setName(tagDTO.getName());
		
		tag = tagService.save(tag);
		return new ResponseEntity<TagDTO>(new TagDTO(tag),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteTag(@PathVariable("id") Long id){
		Tag tag = tagService.findOne(id);
		if(tag != null) {
			tagService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
