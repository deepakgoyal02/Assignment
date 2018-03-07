package com.blk.boot;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.blk.boot.data.GuestBookEntry;
import com.blk.boot.repository.GuestBookRepository;

@EnableResourceServer
@SpringBootApplication
public class GuestBookEntryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestBookEntryApplication.class, args);
	}

	@Bean // this is just to initialize database
	ApplicationRunner init(GuestBookRepository repository) {
		return args -> {
			Stream.of("James", "Mark", "Peter", "Deepak", "Ankit").forEach(name -> {
				GuestBookEntry entry = new GuestBookEntry();
				entry.setName(name);
				entry.setClientId("abc");
				entry.setLastUpdated(LocalDateTime.now());
				repository.save(entry);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
