package demo.service;


import demo.model.Author;

public interface AuthorService {
  Author findByName(String name);
}
