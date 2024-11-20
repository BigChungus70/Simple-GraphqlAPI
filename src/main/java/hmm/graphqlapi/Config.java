package hmm.graphqlapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product potato = new Product("potato", "mm yes botato", 132);
            Product mate = new Product("mate", "", 9999);
            Product juice = new Product("juice", "lemon", 12);
            Product apple = new Product("apple", "", 4);
            productRepository.saveAll(List.of(potato,mate,juice,apple));
        };
    }

}
