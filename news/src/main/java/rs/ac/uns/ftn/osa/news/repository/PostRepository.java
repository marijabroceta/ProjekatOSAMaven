package rs.ac.uns.ftn.osa.news.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import rs.ac.uns.ftn.osa.news.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findAll();

	List<Post> findByTags_Id(Long tagId);

	List<Post> findAllByOrderByDateDesc();

}
