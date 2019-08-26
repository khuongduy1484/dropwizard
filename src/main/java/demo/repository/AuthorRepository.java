package demo.repository;

import demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AuthorRepository extends JpaRepository<Author,Long> {
 public Author findByName(String name);
}
