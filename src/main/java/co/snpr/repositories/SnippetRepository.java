package co.snpr.repositories;

import co.snpr.entities.Snippet;
import org.springframework.data.repository.CrudRepository;

public interface SnippetRepository extends CrudRepository<Snippet, Integer> {
}
