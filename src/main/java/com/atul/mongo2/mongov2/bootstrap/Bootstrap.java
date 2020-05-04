package com.atul.mongo2.mongov2.bootstrap;

import com.atul.mongo2.mongov2.model.DeliveryInfo;
import com.atul.mongo2.mongov2.model.LegoSet;
import com.atul.mongo2.mongov2.model.LegoSetDifficulty;
import com.atul.mongo2.mongov2.model.ProductReview;
import com.atul.mongo2.mongov2.repo.LegosRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;


@Service
public class Bootstrap implements CommandLineRunner {

    private MongoTemplate mongoTemplate;
    private LegosRepo legosRepo;

    public Bootstrap(MongoTemplate mongoTemplate, LegosRepo legosRepo) {
        this.mongoTemplate = mongoTemplate;
        this.legosRepo = legosRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running command line ");
//        mongoTemplate.dropCollection(LegoSet.class);
        legosRepo.deleteAll();
        final LegoSet milleniumFalcon = new LegoSet("1", "fal falcon",
                LegoSetDifficulty.HARD, "star wars",
                Arrays.asList(
                        new ProductReview("ana", "5"),
                        new ProductReview("rama", "5"),
                        new ProductReview("rancho", "9")
                ),
                new DeliveryInfo(LocalDate. now(), 16, true)
        );

        final LegoSet milleniumFalcon2 = new LegoSet("98", "fal falcon",
                LegoSetDifficulty.HARD, "star wars",
                Arrays.asList(
                        new ProductReview("ana", "6"),
                        new ProductReview("rama", "5"),
                        new ProductReview("rancho", "8")
                ),
                new DeliveryInfo(LocalDate. now(), 18, true)
        );

        final LegoSet skyPloice = new LegoSet("2", "sky ",
                LegoSetDifficulty.EASY, "sky wars",
                Arrays.asList(
                        new ProductReview("acko", "10"),
                        new ProductReview("denza", "8"),
                        new ProductReview("tenza", "9")
                ),
                new DeliveryInfo(LocalDate. now(), 16, true)
        );

        final LegoSet mcLaren = new LegoSet("90", "mclaren ",
                LegoSetDifficulty.EASY, "mcleren wars",
                Arrays.asList(
                        new ProductReview("kul", "12"),
                        new ProductReview("dj", "14"),
                        new ProductReview("raksh", "17")
                ),
                new DeliveryInfo(LocalDate. now(), 90, false)
        );

//        mongoTemplate.insertAll(Arrays.asList(mcLaren, milleniumFalcon, skyPloice, milleniumFalcon2));
        legosRepo.insert(Arrays.asList(mcLaren, milleniumFalcon, skyPloice, milleniumFalcon2));
    }

}
