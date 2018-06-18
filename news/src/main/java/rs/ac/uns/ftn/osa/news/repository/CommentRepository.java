package rs.ac.uns.ftn.osa.news.repository;



import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.osa.news.entity.Comment;
import rs.ac.uns.ftn.osa.news.entity.Post;


public interface CommentRepository extends JpaRepository<Comment,Long>{

	List<Comment> findByPost(Post post);

	List<Comment> findAllByOrderByDateDesc();

    List<Comment> findAllByOrderByLikesDesc();

    List<Comment> findAllByOrderByDislikesDesc();

    List<Comment> findByPost(Post post, Sort sort);
}
