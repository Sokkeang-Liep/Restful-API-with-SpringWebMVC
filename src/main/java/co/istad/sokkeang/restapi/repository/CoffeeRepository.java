package co.istad.sokkeang.restapi.repository;

import co.istad.sokkeang.restapi.domain.Coffee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;



import java.util.Arrays;
import java.util.List;

@Repository
public class CoffeeRepository {

    @Bean
    public List<Coffee> beanCoffee(){
        Coffee coffee = new Coffee(1, "Ice Latte", 2.5,"50%");
        Coffee coffee1 = new Coffee(2, "Grean tea",2.5 , "20%");
        Coffee coffee2 = new Coffee(3, "Hot Coffee" ,2.6, "20%");
        return Arrays.asList(coffee, coffee1, coffee2);
    }
}
