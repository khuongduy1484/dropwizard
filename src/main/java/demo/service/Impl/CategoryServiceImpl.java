package demo.service.Impl;


import demo.model.Category;
import demo.repository.CategoryRepository;
import demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;


public class CategoryServiceImpl implements CategoryService {



  @Autowired
  private CategoryRepository categoryRepository;
  @Override
  public Category findById(Long id) {
    return categoryRepository.findById(id).get();
  }

  @Override
  public Category findByName(String name) {
    return categoryRepository.findByName(name);
  }
}
