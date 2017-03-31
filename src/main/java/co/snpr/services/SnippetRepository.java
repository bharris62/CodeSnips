package co.snpr.services;

import co.snpr.entities.Snippet;
import org.springframework.data.repository.CrudRepository;

public interface SnippetRepository extends CrudRepository<Snippet, Integer> {
}
