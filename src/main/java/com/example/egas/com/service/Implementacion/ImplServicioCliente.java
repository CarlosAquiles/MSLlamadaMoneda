package com.example.egas.com.service.Implementacion;

import com.example.egas.com.model.Moneda;
import com.example.egas.com.response.CambioRequest;
import com.example.egas.com.response.CambioResponse;
import com.example.egas.com.response.MonedaResponse;

import com.example.egas.com.service.IServiceCliente;
import com.example.egas.com.service.IServiceMoneda;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ImplServicioCliente implements IServiceCliente {

    private final WebClient webClient;

    // Inyectamos el WebClient a través del constructor
    public ImplServicioCliente(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8090").build();
    }

    @Override
    public Mono<MonedaResponse> listarMoneda() {
        return webClient.get()
                .uri("/msMoneda/mono/listarMoneda")  // Aquí defines la ruta del servicio al que quieres llamar
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Moneda>>() {})
                .map(listaMoneda -> new MonedaResponse(listaMoneda));  // La forma correcta de usar ParameterizedTypeReference
    }

    @Override
    public Mono<CambioResponse> obtenerCambio(Integer idMoneda, Integer cantidad) {
        return webClient.get()
                .uri("/msMoneda/mono/obtenerCambio/"+idMoneda+"/"+cantidad)  // Aquí defines la ruta del servicio al que quieres llamar
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<CambioResponse>() {});  // La forma correcta de usar ParameterizedTypeReference
    }

    @Override
    public Mono<CambioResponse> obtenerCambio2(CambioRequest cambioRequest) {
        return webClient.post()
                .uri("/msMoneda/mono/obtenerCambio2")  // Aquí defines la ruta del servicio al que quieres llamar
                .bodyValue(cambioRequest)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<CambioResponse>() {});  // La forma correcta de usar ParameterizedTypeReference
    }

    @Override
    public Mono<CambioResponse> obtenerCambio3(Integer idMoneda, Integer cantidad) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/msMoneda/mono/obtenerCambio3")
                        .queryParam("idMoneda", idMoneda.toString())
                        .queryParam("cantidad", cantidad.toString())
                        .build())
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
