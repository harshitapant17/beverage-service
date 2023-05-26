package com.harshita.beverageservice.repositories;

import com.harshita.beverageservice.domain.Beverage;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeverageRepository extends PagingAndSortingRepository<Beverage, UUID> {

}
