package fi.karttunen.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.karttunen.Bookstore.domain.Book;
import fi.karttunen.Bookstore.domain.BookstoreRepository;
import fi.karttunen.Bookstore.domain.Category;
import fi.karttunen.Bookstore.domain.CategoryRepository;
import fi.karttunen.Bookstore.domain.User;
import fi.karttunen.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
@Bean
	public CommandLineRunner bookstoreDemo(BookstoreRepository repository, CategoryRepository crepository, UserRepository urepository ) {
		return (args) -> {
			System.out.println(("tallenna muutama kirja"));
			crepository.save(new Category("Jännitys"));
			crepository.save(new Category("Seikkailu"));
			crepository.save(new Category("Rikos"));
			
			repository.save(new Book("Sinuhe Egyptiläinen", "Mika Waltari", 1945, "23424-552-4242-523", 20, crepository.findByName("Jännitys").get(0)));
			repository.save(new Book("Taru sormusten herrasta", "J.R.R Tolkien", 1954, "23824-472-4562-547", 26, crepository.findByName("Seikkailu").get(0)));
			repository.save(new Book("Harry Potter: Viisasten kivi", "J.K Rowling", 1997, "23590-452-4292-599", 30, crepository.findByName("Rikos").get(0)));
		
			User user1 = new User ("user","$2a$10$Oi9Qm5krDl2AB0W2jhqrp.Mvv.gpL9xJlElhgoBo10YRGo3p1Gfi6","USER");
			User user2 = new User ("admin","$2a$10$zMbj4znTuAyi4AvUBWMPAeS72zKm4u.4MIkpJ6L0jjnxmso0iSnZi","ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			System.out.println(("nouda kaikki kirjat"));
			for (Book book : repository.findAll()) {
				System.out.println((book.toString()));
		}
	};
	}
}