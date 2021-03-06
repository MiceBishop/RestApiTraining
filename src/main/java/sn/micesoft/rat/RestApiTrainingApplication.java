package sn.micesoft.rat;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sn.micesoft.rat.repositories.AccountRepository;
import sn.micesoft.rat.repositories.BookmarkRepository;
import sn.micesoft.rat.entities.Bookmark;
import sn.micesoft.rat.entities.Account;

@SpringBootApplication
public class RestApiTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiTrainingApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
		return (evt) -> Arrays.asList("mice,moddy,saalihou,chichi,mikasa,fatba,lem,njombor".split(",")).forEach(a -> {
			Account account = accountRepository.save(new Account(a, "password"));
			bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + a, "A description"));
			bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + a, "A description"));
		});
	}
}
