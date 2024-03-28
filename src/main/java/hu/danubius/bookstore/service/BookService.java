package hu.danubius.bookstore.service;

import hu.danubius.bookstore.restclient.ManualBookServiceApi;
import hu.danubius.bookstore.restclient.api.BookServiceApi;
import hu.danubius.bookstore.restclient.model.GetBooksResponse;
import hu.danubius.bookstore.restclient.model.ManualGetBooksResponse;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookServiceApi bookServiceApi;
    private final ManualBookServiceApi manualBookServiceApi;

    public BookService(BookServiceApi bookServiceApi, ManualBookServiceApi manualBookServiceApi) {
        this.bookServiceApi = bookServiceApi;
        this.manualBookServiceApi = manualBookServiceApi;
    }

    public GetBooksResponse getBooks() {

        return bookServiceApi
            .getBooks(0, 10)
            .block();
    }

    public ManualGetBooksResponse getBooksManually() {

        return manualBookServiceApi
            .getBooks(0, 5)
            .block();
    }

    public void createBook() {
        manualBookServiceApi
            .createBook()
            .block();
    }
}
