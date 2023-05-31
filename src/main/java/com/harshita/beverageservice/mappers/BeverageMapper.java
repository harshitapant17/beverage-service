package com.harshita.beverageservice.mappers;

import com.harshita.beverageservice.domain.Beverage;
import com.harshita.beverageservice.web.model.BeverageDTO;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeverageMapper {
    BeverageDTO beverageToBeverageDto(Beverage beverage);

    Beverage beverageDtoToBeverage(BeverageDTO beverageDTO);
}
