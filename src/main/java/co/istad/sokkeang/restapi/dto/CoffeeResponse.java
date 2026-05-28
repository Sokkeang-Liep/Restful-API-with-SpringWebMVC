package co.istad.sokkeang.restapi.dto;


public record CoffeeResponse(
        String name,
        Double price,
        String description
) {
}
