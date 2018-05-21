package rs.ac.uns.ftn.osa.news.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import rs.ac.uns.ftn.osa.news.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

	List<Tag> findByPosts_Id(Long postId);

	Tag findByName(String name);

}
