package com.example.egas.com.service;

import com.example.egas.com.model.Moneda;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioCliente {

    private final WebClient webClient;

    // Inyectamos el WebClient a través del constructor
    public ServicioCliente(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("localhost:8090").build();
    }

/*    public Mono<List<Moneda>> llamarAServicioExterno() {
        return webClient.get()
                .uri("/msMoneda/mono/listar")  // Aquí defines la ruta del servicio al que quieres llamar
                .retrieve()
                .bodyToMono(ParameterizedTypeReference<List<Moneda>>.class);  // El tipo de respuesta que esperas (en este caso, un String)
    }*/

    public Mono<List<Moneda>> llamarAServicioExterno() {
        return webClient.get()
                .uri("/msMoneda/mono/listar")  // Aquí defines la ruta del servicio al que quieres llamar
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Moneda>>() {});  // La forma correcta de usar ParameterizedTypeReference
    }
}
