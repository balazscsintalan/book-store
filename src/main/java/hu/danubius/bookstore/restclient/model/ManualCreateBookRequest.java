package hu.danubius.bookstore.restclient.model;

import java.time.LocalDate;

public record ManualCreateBookRequest(
    String title,
    String isbn,
    Integer totalPages,
    LocalDate publishedDate
) {
}
