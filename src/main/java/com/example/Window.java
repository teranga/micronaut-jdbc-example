package com.example;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.serde.annotation.Serdeable;


@MappedEntity
@Serdeable
public record Window(
        @Id @GeneratedValue @Nullable Long id,
        @NonNull String manufacturer,
        @NonNull Material material,
        @Relation(Relation.Kind.MANY_TO_ONE)
        @Nullable Room room) {
}
