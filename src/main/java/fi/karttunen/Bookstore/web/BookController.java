package fi.karttunen.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.karttunen.Bookstore.domain.Book;
import fi.karttunen.Bookstore.domain.BookstoreRepository;
import fi.karttunen.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookstoreRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value = {"/", "/booklist"})
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/add")
	public String addBook (Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	 repository.deleteById(bookId);
	 return "redirect:../booklist";
	}
	
	
	@RequestMapping(value = "/edit/{id}")
		public String addBook(@PathVariable("id") Long bookId, Model model){
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
}
