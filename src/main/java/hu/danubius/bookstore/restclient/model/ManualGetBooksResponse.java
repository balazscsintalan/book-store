package hu.danubius.bookstore.restclient.model;

import java.util.List;

public record ManualGetBooksResponse(
    List<ManualBook> books,
    int totalPages,
    long totalElements
) {
}
