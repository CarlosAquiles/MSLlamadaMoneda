package com.example.egas.com.service;

import com.example.egas.com.model.Moneda;
import com.example.egas.com.response.CambioResponse;
import com.example.egas.com.response.MonedaResponse;

import org.springframework.core.ParameterizedTypeReference;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ServicioCliente implements IServiceMoneda {

    private final WebClient webClient;

    // Inyectamos el WebClient a través del constructor
    public ServicioCliente(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8090").build();
    }

    @Override
    public Mono<MonedaResponse> listarMoneda() {
        return llamarAServicioExterno()
                .map(listaMoneda -> new MonedaResponse(listaMoneda));  // La forma correcta de usar ParameterizedTypeReference
    }

    private Mono<List<Moneda>> llamarAServicioExterno() {
        return webClient.get()
                .uri("/msMoneda/mono/listar")  // Aquí defines la ruta del servicio al que quieres llamar
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Moneda>>() {});  // La forma correcta de usar ParameterizedTypeReference
    }

    @Override
    public Mono<CambioResponse> obtenerValor(Integer idMoneda, Integer cantidad) {
        return llamarBServicioExterno(idMoneda, cantidad);  // La forma correcta de usar ParameterizedTypeReference
    }

    private Mono<CambioResponse> llamarBServicioExterno(Integer idMoneda, Integer cantidad) {
        return webClient.get()
                .uri("/msMoneda/mono/obtenerCambio/"+idMoneda+"/"+cantidad)  // Aquí defines la ruta del servicio al que quieres llamar
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<CambioResponse>() {});  // La forma correcta de usar ParameterizedTypeReference
    }


/*    @Override
    public Mono<MonedaResponse> listarMoneda() {
        return llamarAServicioExterno()
                .flatMapMany(Flux::fromIterable)
                //.map(listaMoneda -> new MonedaResponse(listaMoneda))
                .filter(moneda -> moneda.);  // La forma correcta de usar ParameterizedTypeReference
    }*/
}
