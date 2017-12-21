package config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import repositories.HashRepository;
import services.impl.HashServiceImpl;
import web.controller.NoteController;


@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {
    HashRepository.class,
    HashServiceImpl.class,
    NoteController.class
})
public class WebConfig extends WebMvcConfigurerAdapter {

}
