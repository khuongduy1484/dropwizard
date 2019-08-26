package demo;


import com.google.inject.Guice;
import com.google.inject.Injector;
import demo.controller.BookController;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class DemoApplication extends Application<Configuration> {

  public static void main(String[] args) throws Exception {
    new DemoApplication().run(args);
  }


  public void run(Configuration configuration, Environment environment) throws Exception {

    environment.jersey().register(BookController.class);
  }
}
