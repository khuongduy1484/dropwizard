package demo.service;


import demo.model.Book;

import java.util.List;

public interface BookService {
  List<Book> findAll();

  Book findById(Long id);

  void save(Book book);

  void remove(Book book);
}
