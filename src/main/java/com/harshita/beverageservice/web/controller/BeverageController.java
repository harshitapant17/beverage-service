package com.harshita.beverageservice.web.controller;

import com.harshita.beverageservice.web.model.BeverageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beverage")
@RestController
public class BeverageController {
    
    @GetMapping("/{id}")
    public ResponseEntity<BeverageDTO> getBeverageById(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(BeverageDTO.builder().build(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity saveNewBeverage(@RequestBody BeverageDTO newBeverage)
    {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set();

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBeverageById(@PathVariable("id") UUID id, @RequestBody BeverageDTO beverage)
    {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
