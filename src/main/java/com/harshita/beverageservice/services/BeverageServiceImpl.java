package com.harshita.beverageservice.services;

import com.harshita.beverageservice.domain.Beverage;
import com.harshita.beverageservice.mappers.BeverageMapper;
import com.harshita.beverageservice.repositories.BeverageRepository;
import com.harshita.beverageservice.web.controller.NotFoundException;
import com.harshita.beverageservice.web.model.BeverageDTO;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class BeverageServiceImpl implements BeverageService {

    private final BeverageRepository repository;
    private final BeverageMapper beverageMapper;
    @Override
    public BeverageDTO getById(UUID id) {
        return beverageMapper.beverageToBeverageDto(
                repository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeverageDTO saveNewBeverage(BeverageDTO newBeverage) {
        return beverageMapper.beverageToBeverageDto(
                repository.save(beverageMapper.beverageDtoToBeverage(newBeverage)));
    }

    @Override
    public BeverageDTO updateBeverage(UUID id, BeverageDTO beverageDto) {

        Beverage beverage = repository.findById(id).orElseThrow(NotFoundException::new);

        beverage.setBeverageName(beverageDto.getBeverageName());
        beverage.setBeverageStyle(beverageDto.getBeverageStyle().name());
        beverage.setPrice(beverageDto.getPrice());
        beverage.setUpc(beverageDto.getUpc());

        return beverageMapper.beverageToBeverageDto(repository.save(beverage));
    }
}
