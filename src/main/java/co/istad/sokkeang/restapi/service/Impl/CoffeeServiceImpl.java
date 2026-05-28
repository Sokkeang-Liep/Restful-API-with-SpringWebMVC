package co.istad.sokkeang.restapi.service.Impl;

import co.istad.sokkeang.restapi.domain.Coffee;
import co.istad.sokkeang.restapi.dto.CoffeeResponse;
import co.istad.sokkeang.restapi.repository.CoffeeRepository;
import co.istad.sokkeang.restapi.service.CoffeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

        private final CoffeeRepository coffeeRepository;

        public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
            this.coffeeRepository = coffeeRepository;
        }


//    public List<Coffee> getCoffees() {
//        List<Coffee> coffees = coffeeRepository.beanCoffee();
//        return coffees.stream()
//                .filter(coffee -> coffee.getId() > 1
//                ).toList();
//    }

        @Override
        public List<Coffee> getCoffees() {
            return coffeeRepository.beanCoffee();
        }

        public CoffeeResponse getCoffeeById(Integer id) {
            CoffeeResponse res = coffeeRepository.beanCoffee().stream().filter(d->d.getId().equals(id)).
                    map(d->new CoffeeResponse(d.getName(),d.getPrice(),d.getDescription()))
                    .findFirst().orElseThrow(()->new RuntimeException("Id not found!"));
            return res;
        }

        @Override
        public List<CoffeeResponse> searchByName(String name, Double price) {
            List<CoffeeResponse> names = coffeeRepository.beanCoffee().stream()
                    .filter(d->d.getName().toLowerCase().contains(name.toLowerCase()) && d.getPrice().equals(price))
                    .map(d->new CoffeeResponse(d.getName(),d.getPrice(),d.getDescription()))
                    .toList();
            return names;
        }



    }