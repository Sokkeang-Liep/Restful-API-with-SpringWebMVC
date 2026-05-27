package co.istad.sokkeang.restapi.service;

import co.istad.sokkeang.restapi.dto.CoffeeResponse;

import java.util.List;

public interface CoffeeService {

    List<CoffeeResponse> getCoffees();
}
