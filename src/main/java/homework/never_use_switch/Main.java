package homework.never_use_switch;

import com.github.javafaker.Faker;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("homework");
    }

    @Bean
    public Faker getFaker(){
        return new Faker();
    }

    @Bean
    public DataFactory getDataFactory(){
        return new DataFactory();
    }
}