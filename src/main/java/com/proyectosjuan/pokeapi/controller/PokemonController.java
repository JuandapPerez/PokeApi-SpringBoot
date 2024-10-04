package com.proyectosjuan.pokeapi.controller;


import com.proyectosjuan.pokeapi.model.PokemonDTO;
import com.proyectosjuan.pokeapi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/buscar")
    public String buscarPokemon(@RequestParam String nombre, Model model) {
        PokemonDTO pokemon = pokemonService.buscarPokemon(nombre);
        model.addAttribute("pokemon", pokemon);
        return "resultado";
    }
}