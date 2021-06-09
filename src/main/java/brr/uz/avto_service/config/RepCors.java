package brr.uz.avto_service.config;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RepCors implements  {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.getCorsRegistry()
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

}