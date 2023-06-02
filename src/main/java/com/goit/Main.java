package com.goit;

import com.goit.database.Database;
import com.goit.entity.Client;
import com.goit.service.ClientCrudService;
import com.goit.service.CrudService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        database.migrate();

        CrudService<Client> clientCrudService = new ClientCrudService();

//        Client client = clientCrudService.getById(10);
//        System.out.println("client = " + client);

        Client newClient = new Client();
        newClient.setName("New Client");
        clientCrudService.create(newClient);
        List<Client> clients = clientCrudService.listAll();
        System.out.println("clients = " + clients);

    }
}