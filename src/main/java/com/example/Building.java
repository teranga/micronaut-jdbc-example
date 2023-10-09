package com.example;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

@MappedEntity
@Serdeable
public record Building(
        @Id @GeneratedValue @Nullable Long id,
        @NonNull String address,
        @Min(1) @Max(200) int floorCount,
        @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "building", cascade = {Relation.Cascade.ALL})
        List<Room> rooms
) {
}
