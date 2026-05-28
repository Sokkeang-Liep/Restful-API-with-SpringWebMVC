package co.istad.sokkeang.restapi.controller;


import co.istad.sokkeang.restapi.domain.Coffee;
import co.istad.sokkeang.restapi.dto.CoffeeResponse;
import co.istad.sokkeang.restapi.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService){

        this.coffeeService = coffeeService;
    }

    @GetMapping
    public List<Coffee> getCoffees(){
        return coffeeService.getCoffees();
    }

    @GetMapping("/{id}")
    public CoffeeResponse getCoffeeById(@PathVariable Integer id) {
        log.info("GET id: {}", id);
        return coffeeService.getCoffeeById(id);
    }

    @GetMapping("/search")
    public List<CoffeeResponse> searchCoffeeByName(
            @RequestParam (required = false, defaultValue = "") String name,
            @RequestParam (required = false, defaultValue = "") Double price
    ) {
        log.info("Get name: {}", name);
        log.info("Get name: {}", price);

        return coffeeService.searchByName(name,price);
    }
}
