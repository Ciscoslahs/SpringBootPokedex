package com.Ciscoslahs.Pokedex;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PokedexController {

    private final PokedexService pokedexService;

    public PokedexController(PokedexService pokedexService) {
        this.pokedexService = pokedexService;
    }

    @GetMapping("/findByName")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<String> monsByName(@RequestParam String query) {
        return pokedexService.findByName(query);
    }

    @GetMapping("findByStats")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<String> monsByStats(@RequestParam String query) {
        return pokedexService.findByStats(Integer.parseInt(query));
    }

    @GetMapping("/randomMon")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<String> randomMon() {
        return Collections.singletonList(pokedexService.randomPokemon());
    }
}
