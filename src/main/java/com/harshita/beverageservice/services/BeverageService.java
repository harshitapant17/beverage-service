package com.harshita.beverageservice.services;

import com.harshita.beverageservice.web.model.BeverageDTO;

import java.util.UUID;

public interface BeverageService {
    BeverageDTO getById(UUID id);

    BeverageDTO saveNewBeverage(BeverageDTO newBeverage);

    BeverageDTO updateBeverage(UUID id, BeverageDTO beverage);
}
