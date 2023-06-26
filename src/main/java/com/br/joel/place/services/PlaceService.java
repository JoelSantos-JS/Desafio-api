package com.br.joel.place.services;

import com.br.joel.place.api.PlaceDTO;
import com.br.joel.place.domain.Place;
import com.br.joel.place.repository.PlaceRepository;
import com.br.joel.place.web.PlaceMapper;
import com.github.slugify.Slugify;

import reactor.core.publisher.Mono;

public class PlaceService {
    PlaceRepository placeRepository;

    private Slugify slg;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slg = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceDTO place) {
        Place place2 = new Place(null, place.name(), slg.slugify(place.name()), place.state(), null, null);

        return placeRepository.save(place2);

    }

    public Mono<Place> edit(Long id, PlaceDTO placeRequest) {
        return placeRepository.findById(id)
                .map(place -> PlaceMapper.updatePlaceFromDTO(placeRequest, place))
                .map(place -> place.withSlug(slg.slugify(place.name())))
                .flatMap(placeRepository::save);
    }

    public Mono<Place> get(Long id) {
        return placeRepository.findById(id);
    }
}
