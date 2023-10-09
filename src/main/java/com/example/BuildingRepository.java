package com.example;

import io.micronaut.data.annotation.*;
import io.micronaut.data.model.*;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;

@JdbcRepository(dialect = Dialect.H2)
interface BuildingRepository extends CrudRepository<Building, Long> {

}