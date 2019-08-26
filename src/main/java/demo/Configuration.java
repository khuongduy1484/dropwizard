package demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.Guice;
import com.google.inject.Injector;
import demo.service.BookService;
import demo.service.CategoryService;
import demo.service.Impl.CategoryServiceImpl;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.ext.Provider;

public class Configuration extends io.dropwizard.Configuration {

//    Injector injector = Guice.createInjector(new GuiceModule());

    @NotNull
    @Valid
    private DataSourceFactory dataSourceFactory
      = new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }
    private String myConfig;

    public String getMyConfig() {
        return myConfig;
    }

    public void setMyConfig(String myConfig) {
        this.myConfig = myConfig;
    }
}
