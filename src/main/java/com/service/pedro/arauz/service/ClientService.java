package com.service.pedro.arauz.service;

import com.service.pedro.arauz.entity.Client;
import com.service.pedro.arauz.presentation.presenter.ClientPresenter;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.List;

public interface ClientService {

    ClientPresenter save(ClientPresenter clientPresenter) throws ParseException;

    ClientPresenter getClient(String identification);

    List<ClientPresenter> getAllClient();
}
