package com.dnacreative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class SpringCmsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringCmsApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringCmsApplication.class);
    }
	
	/*
	@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
      return (container -> {
   	   //route all errors towards /error .
   	   final ErrorPage errorPage=new ErrorPage("/errors");
   	   container.addErrorPages(errorPage);
      });s
   }
	*/
}
