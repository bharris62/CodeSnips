package co.snpr.repositories;

import co.snpr.entities.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by abbh62 on 5/5/2017.
 */
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findAllBySnippetIdAndIsLiveTrue(int id);

    @Transactional
    @Modifying
    @Query("update Comment i set i.isLive = ?1 where i.id = ?2")
    void updateLive(boolean live, int id);

}
