package com.proyectosjuan.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokemonDTO(
        int id,
        String name,
        int height,
        int weight
) {}