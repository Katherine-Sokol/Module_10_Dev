package com.goit.service;

import com.goit.database.Database;
import com.goit.entity.Client;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientCrudServiceTests {

    static ClientCrudService clientCrudService;

    @BeforeAll
    static void beforeAll() {
        Database database = Database.getInstance();
        database.migrate();
        clientCrudService = new ClientCrudService();
    }

    @Test
    void testThatClientCreatedCorrectly() {
        List<Client> oldList = clientCrudService.listAll();
        Client newClient = new Client();
        newClient.setName("New Name");
        clientCrudService.create(newClient);
        Assertions.assertEquals(clientCrudService.listAll().size(), oldList.size() + 1);
    }

    @Test
    void testThatClientIsGottenByIdCorrectly() {
        Client newClient = new Client();
        newClient.setName("First Name");
        clientCrudService.create(newClient);
        Client client = clientCrudService.getById(newClient.getId());
        Assertions.assertEquals(newClient.getName(), client.getName());
    }

    @Test
    void testThatClientsAreAddedToList() {
        List<Client> clients = clientCrudService.listAll();
        assertFalse(clients.isEmpty());
    }

    @Test
    void testThatClientIsUpdated() {
        Client client = new Client();
        client.setName("Old Name");
        clientCrudService.create(client);
        String newName = "New name";
        client.setName(newName);
        clientCrudService.update(client);
        Assertions.assertEquals(client.getName(), newName);
    }

    @Test
    void testThatClientIsDeletedCorrectly() {
        List<Client> oldList = clientCrudService.listAll();
        Client client = clientCrudService.getById(10);
        clientCrudService.delete(client);
        List<Client> listAfterDelete = clientCrudService.listAll();
        assertEquals(listAfterDelete.size(), oldList.size() - 1);
    }

}