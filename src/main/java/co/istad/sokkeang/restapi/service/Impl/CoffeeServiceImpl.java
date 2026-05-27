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

    @Override
    public List<CoffeeResponse> getCoffees() {
        List<Coffee> coffees = coffeeRepository.beanCoffee();

        return coffees.stream()
                .filter(coffee -> coffee.getId() > 1)
                .map(coffee -> new CoffeeResponse(coffee.getName(), coffee.getDescription()))
                .toList();
    }
}