package com.service.pedro.arauz.presentation.controller;

import com.service.pedro.arauz.entity.Client;
import com.service.pedro.arauz.presentation.presenter.ClientPresenter;
import com.service.pedro.arauz.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/clientes")
    public ClientPresenter saveClientPresenter(@RequestBody ClientPresenter clientPresenter) throws ParseException {
        return clientService.save(clientPresenter);
    }

    @GetMapping("/clientes/search/identification")
    public ClientPresenter getClientByIdentification(@RequestParam String identification) {
        return clientService.getClient(identification);
    }

    @GetMapping("/clientes/search")
    public List<ClientPresenter> getClients() {
        return clientService.getAllClient();
    }

    @PutMapping("/clientes/update")
    public ClientPresenter updateClientPresenter(@RequestBody ClientPresenter clientPresenter) throws ParseException {
        return clientService.save(clientPresenter);
    }


}
