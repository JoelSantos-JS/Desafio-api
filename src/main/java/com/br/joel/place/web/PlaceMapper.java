package com.br.joel.place.web;

import org.springframework.util.StringUtils;

import com.br.joel.place.api.PlaceDTO;
import com.br.joel.place.domain.Place;

public class PlaceMapper {

    public static PlaceDTO fromPlaceToResponse(Place place) {
        return new PlaceDTO(place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }

    public static Place updatePlaceFromDTO(PlaceDTO placeRequest, Place place) {
        final String name = StringUtils.hasText(placeRequest.name()) ? placeRequest.name() : place.name();

        final String state = StringUtils.hasText(placeRequest.state()) ? placeRequest.state() : place.state();
        return new Place(place.id(), name, place.slug(), state, place.createdAt(), place.updatedAt());
    }

}
