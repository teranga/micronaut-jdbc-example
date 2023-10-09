package com.example;

import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Controller
@Validated
public class DwellingController {

    private final BuildingRepository buildingRepository;
    private final WindowRepository windowRepository;
    private final RoomRepository roomRepository;

    public DwellingController(BuildingRepository buildingRepository, WindowRepository windowRepository, RoomRepository roomRepository) {
        this.buildingRepository = buildingRepository;
        this.windowRepository = windowRepository;
        this.roomRepository = roomRepository;
    }

    @Post("/buildings")
    public Building createBuilding(@Body @Valid CreateBuildingCommand command) {
        final List<Room> rooms = new ArrayList<>();
        final Building building = new Building(null, command.address(), command.floors(), rooms);
        for (int i = 0; i < command.rooms(); i++) {
            List<Window> windows = new ArrayList<>();
            Room room = new Room(null, 100 + 1, 100 + i, windows, building);
            rooms.add(room);
            windows.add(new Window(null, command.windowManufacturer(), command.windowMaterial(), room));
        }
        return buildingRepository.save(building);
    }

    @Get(uri="/dwelling", produces="text/plain")
    public String index() {
        return "Example Response";
    }


}