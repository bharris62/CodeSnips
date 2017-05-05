package co.snpr.repositories;

import co.snpr.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by abbh62 on 5/5/2017.
 */
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findAllBySnippetId(int id);
}
