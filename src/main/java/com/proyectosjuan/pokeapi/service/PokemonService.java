package com.proyectosjuan.pokeapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectosjuan.pokeapi.model.PokemonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PokemonService {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public PokemonService(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public PokemonDTO buscarPokemon(String nombre) {
        try {
            String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + nombre.toLowerCase();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return objectMapper.readValue(response.body(), PokemonDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el Pokémon", e);
        }
    }
}
