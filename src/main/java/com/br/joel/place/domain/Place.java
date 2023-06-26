package com.br.joel.place.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public record Place(Long id, String name, String slug, String state, @CreatedDate LocalDateTime createdAt,
        @LastModifiedDate LocalDateTime updatedAt) {

    public Place withSlug(String slug) {
        return new Place(id, name, slug, state, createdAt, updatedAt);
    }

}