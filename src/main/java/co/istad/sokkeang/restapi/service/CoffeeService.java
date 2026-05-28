package co.istad.sokkeang.restapi.service;
import co.istad.sokkeang.restapi.domain.Coffee;
import co.istad.sokkeang.restapi.dto.CoffeeResponse;

import java.util.List;

public interface CoffeeService {


    List<Coffee> getCoffees();

    CoffeeResponse getCoffeeById(Integer id);
    List<CoffeeResponse> searchByName(String name,Double price);
}
