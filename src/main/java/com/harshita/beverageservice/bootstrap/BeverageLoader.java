package com.harshita.beverageservice.bootstrap;

import com.harshita.beverageservice.domain.Beverage;
import com.harshita.beverageservice.repositories.BeverageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeverageLoader implements CommandLineRunner {

    public static final String BEVERAGE1_UPC="06312324200036";
    public static final String BEVERAGE2_UPC="06312324200019";
    public static final String BEVERAGE3_UPC="003783375213";


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
                    .upc(BEVERAGE1_UPC)
                    .price(new BigDecimal("250"))
                    .build());

            beverageRepository.save(Beverage.builder()
                    .beverageName("Melon Smash")
                    .beverageStyle("Regular")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEVERAGE2_UPC)
                    .price(new BigDecimal("310"))
                    .build());

            beverageRepository.save(Beverage.builder()
                    .beverageName("Orange Passion")
                    .beverageStyle("Regular")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEVERAGE3_UPC)
                    .price(new BigDecimal("220"))
                    .build());
        }

        System.out.println("Loaded Beverages: "+beverageRepository.count());
    }
}
