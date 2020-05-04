package com.atul.mongo2.mongov2.bootstrap;

import com.atul.mongo2.mongov2.model.DeliveryInfo;
import com.atul.mongo2.mongov2.model.LegoSet;
import com.atul.mongo2.mongov2.model.LegoSetDifficulty;
import com.atul.mongo2.mongov2.model.ProductReview;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;


@Service
public class Bootstrap implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running ");

        final LegoSet milleniumFalcon = new LegoSet("1", "millineum falcon",
                LegoSetDifficulty.EASY, "Start wars",
                Arrays.asList(
                        new ProductReview("ana", "5"),
                        new ProductReview("rama", "5"),
                        new ProductReview("rancho", "9")
                ),
                new DeliveryInfo(LocalDate. now(), 16, true)
        );

        final LegoSet skyPloice = new LegoSet("2", "sky falcon",
                LegoSetDifficulty.EASY, "sky wars",
                Arrays.asList(
                        new ProductReview("acko", "5"),
                        new ProductReview("denza", "5"),
                        new ProductReview("tenza", "9")
                ),
                new DeliveryInfo(LocalDate. now(), 16, true)
        );

        final LegoSet mcLaren = new LegoSet("1", "mclaren falcon",
                LegoSetDifficulty.EASY, "mcleren wars",
                Arrays.asList(
                        new ProductReview("kul", "5"),
                        new ProductReview("dj", "5"),
                        new ProductReview("raksh", "9")
                ),
                new DeliveryInfo(LocalDate. now(), 90, false)
        );
    }

}
