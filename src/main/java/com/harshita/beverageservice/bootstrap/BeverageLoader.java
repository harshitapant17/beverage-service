package com.harshita.beverageservice.bootstrap;

import com.harshita.beverageservice.domain.Beverage;
import com.harshita.beverageservice.repositories.BeverageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeverageLoader implements CommandLineRunner {

    private final BeverageRepository beverageRepository;

    public BeverageLoader(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeverageObjects();
    }

    private void loadBeverageObjects() {

        if(beverageRepository.count()==0)
        {
            beverageRepository.save(Beverage.builder()
                    .beverageName("Virgin Mojito")
                    .beverageStyle("Regular")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(3370100000001L)
                    .price(new BigDecimal("250"))
                    .build());

            beverageRepository.save(Beverage.builder()
                    .beverageName("Melon Smash")
                    .beverageStyle("Regular")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(3370100000002L)
                    .price(new BigDecimal("310"))
                    .build());
        }

        System.out.println("Loaded Beverages: "+beverageRepository.count());
    }
}
