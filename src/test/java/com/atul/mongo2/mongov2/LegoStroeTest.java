package com.atul.mongo2.mongov2;

import com.atul.mongo2.mongov2.model.DeliveryInfo;
import com.atul.mongo2.mongov2.model.LegoSet;
import com.atul.mongo2.mongov2.model.LegoSetDifficulty;
import com.atul.mongo2.mongov2.model.ProductReview;
import com.atul.mongo2.mongov2.repo.LegosRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//@DataMongoTest
class LegoStroeTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private LegosRepo legosRepo;


	@BeforeEach
	void setUp() {
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
		legosRepo.insert(milleniumFalcon);
		legosRepo.insert(milleniumFalcon2);
	}

	@Test
	void name() {

		List<LegoSet> byALlReview = (List<LegoSet>) legosRepo.findByALlReview("10");
		System.out.println();
	}

	@Test
	void contextLoads() {
	}

}
