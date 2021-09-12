package fi.karttunen.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import fi.karttunen.Bookstore.domain.Book;
import fi.karttunen.Bookstore.domain.BookstoreRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
@Bean
	public CommandLineRunner bookstoreDemo(BookstoreRepository repository) {
		return (args) -> {
			System.out.println(("tallenna muutama kirja"));
			repository.save(new Book("Sinuhe Egyptiläinen", "Mika Waltari", 1945, "23424-552-4242-523", 20));
			repository.save(new Book("Taru sormusten herrasta", "J.R.R Tolkien", 1954, "23824-472-4562-547", 26));
			repository.save(new Book("Harry Potter: Viisasten kivi", "J.K Rowling", 1997, "23590-452-4292-599", 30));
		
			System.out.println(("nouda kaikki kirjat"));
			for (Book book : repository.findAll()) {
				System.out.println((book.toString()));
		}
	};
	}
}