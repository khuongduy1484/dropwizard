package demo;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import demo.service.CategoryService;
import demo.service.Impl.CategoryServiceImpl;



public class GuiceModule extends AbstractModule {


  @Provides
  public CategoryService categoryService() {
    return new CategoryServiceImpl();
  }

  @Override
  protected void configure() {
bind(CategoryService.class).to(CategoryServiceImpl.class);

  }
}
