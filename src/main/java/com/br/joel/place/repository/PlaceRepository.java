package com.br.joel.place.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.br.joel.place.domain.Place;

public interface PlaceRepository extends ReactiveCrudRepository<Place, Long> {

}
