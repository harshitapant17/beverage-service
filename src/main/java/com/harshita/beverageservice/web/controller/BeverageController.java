package com.harshita.beverageservice.web.controller;

import com.harshita.beverageservice.services.BeverageService;
import com.harshita.beverageservice.web.model.BeverageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beverage")
@RestController
public class BeverageController {

    private final BeverageService beverageService;
    
    @GetMapping("/{id}")
    public ResponseEntity<BeverageDTO> getBeverageById(@PathVariable("id") UUID id)
    {

        return new ResponseEntity<>(beverageService.getById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity saveNewBeverage(@RequestBody @Validated BeverageDTO newBeverage)
    {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set();

        return new ResponseEntity<>(beverageService.saveNewBeverage(newBeverage),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBeverageById(@PathVariable("id") UUID id, @RequestBody @Validated BeverageDTO beverage)
    {
        return new ResponseEntity<>(beverageService.updateBeverage(id,beverage),HttpStatus.NO_CONTENT);
    }

}
