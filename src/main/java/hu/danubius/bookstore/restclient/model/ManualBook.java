package hu.danubius.bookstore.restclient.model;

import java.time.LocalDate;

public record ManualBook(

    String title,
    String isbn,
    Integer totalPages,
    LocalDate publishedDate
) {
}
