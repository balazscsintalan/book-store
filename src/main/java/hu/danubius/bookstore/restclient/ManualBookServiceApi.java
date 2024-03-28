package hu.danubius.bookstore.restclient;

import hu.danubius.bookstore.restclient.model.ManualCreateBookRequest;
import hu.danubius.bookstore.restclient.model.ManualGetBooksResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class ManualBookServiceApi {

    private final WebClient webClient;

    public ManualBookServiceApi(
        @Qualifier("bookApi") WebClient webClient
    ) {
        this.webClient = webClient;
    }

    public Mono<ManualGetBooksResponse> getBooks(Integer page, Integer size) {
        return webClient.get()
            .uri(builder -> builder
                .path("/books")
                .queryParam("page", page)
                .queryParam("size", size)
                .build()
            )
            .retrieve()
            .bodyToMono(ManualGetBooksResponse.class);
    }

    public Mono<Void> createBook() {
        return webClient.post()
            .uri("/books")
            .bodyValue(
                new ManualCreateBookRequest(
                    "Oathbringer",
                    "asdasdsadasdas",
                    500,
                    LocalDate.now()
                )
            )
            .retrieve()
            .bodyToMono(Void.class);
    }
}
