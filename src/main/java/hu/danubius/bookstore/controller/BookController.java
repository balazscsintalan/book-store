package hu.danubius.bookstore.controller;

import hu.danubius.bookstore.restclient.model.GetBooksResponse;
import hu.danubius.bookstore.restclient.model.ManualGetBooksResponse;
import hu.danubius.bookstore.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public GetBooksResponse getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/manual-books")
    public ManualGetBooksResponse getBooksManually() {
        return bookService.getBooksManually();
    }

    @PostMapping("/books")
    public void createBook() {
        bookService.createBook();
    }

}
