package com.br.joel.place.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.joel.place.api.PlaceDTO;
import com.br.joel.place.services.PlaceService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {

    PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;

    }

    @PostMapping
    public ResponseEntity<Mono<PlaceDTO>> create(@RequestBody PlaceDTO place) {
        var placeResponse = placeService.create(place).map(e -> new PlaceMapper().fromPlaceToResponse(e));
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mono<PlaceDTO>> get(@PathVariable Long id) {
        var placeResponse = placeService.get(id).map(e -> new PlaceMapper().fromPlaceToResponse(e));
        return ResponseEntity.ok().body(placeResponse);
    }

}
