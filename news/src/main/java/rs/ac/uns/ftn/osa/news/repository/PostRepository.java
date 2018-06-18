package rs.ac.uns.ftn.osa.news.repository;

import java.util.List;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rs.ac.uns.ftn.osa.news.entity.Post;
import rs.ac.uns.ftn.osa.news.entity.User;

public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findAll();

	List<Post> findByTags_Id(Long tagId);

	List<Post> findAllByOrderByDateDesc();

	List<Post> findAllByOrderByLikes();

	List<Post> findAll(Sort sort);

    List<Post> findAllByOrderByDislikes();

	List<Post> findByAuthor(User user);

	List<Post> findByTags_Name(String name);
}
