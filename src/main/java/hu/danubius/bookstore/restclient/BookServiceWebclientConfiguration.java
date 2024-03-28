package hu.danubius.bookstore.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BookServiceWebclientConfiguration {

    @Value("${bookStore.bookService.url}")
    private String bookServiceUrl;

    @Value("${bookStore.bookService.username}")
    private String bookServiceUsername;

    @Value("${bookStore.bookService.password}")
    private String bookServicePassword;

    @Bean("bookApi")
    public WebClient createBookServiceWebclient() {
        return WebClient.builder()
            .baseUrl(bookServiceUrl)
            .filter(ExchangeFilterFunctions
                .basicAuthentication(
                    bookServiceUsername,
                    bookServicePassword
                )
            )
            .build();
    }
}
