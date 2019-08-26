package demo.service.Impl;


import demo.model.Book;
import demo.repository.BookRepository;
import demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
 @Autowired
 private BookRepository bookRepository;


  @Override
  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  @Override
  public Book findById(Long id) {
    return bookRepository.findById(id).get();
  }

  @Override
  public void save(Book book) {
    bookRepository.save(book);

  }

  @Override
  public void remove(Book book) {
bookRepository.delete(book);
  }
}
