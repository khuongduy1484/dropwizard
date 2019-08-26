package demo.service;

import demo.model.Category;

public interface CategoryService {
  Category findById(Long id);
  Category findByName(String name);
}
