package com.obvio.complaintsapi;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.obvio.complaintsapi.config.ComplaintsCascadeSaveMongoEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@Configuration
@EnableMongoRepositories
public class ComplaintsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplaintsApiApplication.class, args);
	}

	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate((MongoClient) mongo(), "complaint");
	}

	@Bean
	public ComplaintsCascadeSaveMongoEventListener complaintsCascadingMongoEventListener() {
		return new ComplaintsCascadeSaveMongoEventListener();
	}
}
