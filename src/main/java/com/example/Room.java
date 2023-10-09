package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

import java.util.List;

@MappedEntity
@Serdeable
public record Room(
        @Id @GeneratedValue @Nullable Long id,
        @Min(100) @Max(3000) int number,
        @Positive double surface,
        @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "room", cascade = {Relation.Cascade.ALL})
        List<Window> windows,
        @Relation(Relation.Kind.MANY_TO_ONE)
        @Nullable Building building) {
}
