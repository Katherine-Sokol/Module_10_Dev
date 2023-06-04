package com.goit.service;

import com.goit.database.Database;
import com.goit.entity.Planet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PlanetCrudServiceTests {

    static PlanetCrudService planetCrudService;

    @BeforeAll
    static void beforeAll() {
        Database database = Database.getInstance();
        database.migrate();
        planetCrudService = new PlanetCrudService();
    }

    @Test
    void testThatClientCreatedCorrectly() {
        List<Planet> oldList = planetCrudService.listAll();
        Planet newPlanet = new Planet();
        newPlanet.setId("NNN");
        newPlanet.setName("New Name");
        planetCrudService.create(newPlanet);
        Assertions.assertEquals(planetCrudService.listAll().size(), oldList.size() + 1);
    }

    @Test
    void testThatClientIsGottenByIdCorrectly() {
        Planet newPlanet = new Planet();
        newPlanet.setName("New Planet");
        newPlanet.setId("NPT");
        planetCrudService.create(newPlanet);
        Planet planet = planetCrudService.getById(newPlanet.getId());
        Assertions.assertEquals(newPlanet.getName(), planet.getName());
    }

    @Test
    void testThatClientsAreAddedToList() {
        List<Planet> clients = planetCrudService.listAll();
        assertFalse(clients.isEmpty());
    }

    @Test
    void testThatClientIsUpdated() {
        Planet planet = new Planet();
        planet.setName("Old Name");
        planet.setId("OLD");
        planetCrudService.create(planet);
        String newName = "New name";
        planet.setName(newName);
        planetCrudService.update(planet);
        Assertions.assertEquals(planet.getName(), newName);
    }

    @Test
    void testThatClientIsDeletedCorrectly() {
        List<Planet> oldList = planetCrudService.listAll();
        Planet planet = planetCrudService.getById("MER");
        planetCrudService.delete(planet);
        List<Planet> listAfterDelete = planetCrudService.listAll();
        assertEquals(listAfterDelete.size(), oldList.size() - 1);
    }

}