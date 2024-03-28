package hu.danubius.bookstore.restclient;

import hu.danubius.bookstore.restclient.api.BookServiceApi;
import hu.danubius.bookstore.restclient.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookServicesConfiguration {

    @Value("${bookStore.bookService.url}")
    private String bookServiceUrl;

    @Value("${bookStore.bookService.username}")
    private String bookServiceUsername;

    @Value("${bookStore.bookService.password}")
    private String bookServicePassword;

    @Bean
    public BookServiceApi createBookService() {
        ApiClient client = new ApiClient();
        client.setBasePath(bookServiceUrl);
        client.setUsername(bookServiceUsername);
        client.setPassword(bookServicePassword);

        return new BookServiceApi(client);
    }
}
