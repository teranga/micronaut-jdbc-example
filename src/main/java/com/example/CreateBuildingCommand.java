package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record CreateBuildingCommand(String address, int floors, int rooms, double defaultRoomSurface, String windowManufacturer, Material windowMaterial) {
}
