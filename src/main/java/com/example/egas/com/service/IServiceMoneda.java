package com.example.egas.com.service;


import com.example.egas.com.response.CambioRequest;
import com.example.egas.com.response.CambioResponse;
import com.example.egas.com.response.MonedaResponse;
import reactor.core.publisher.Mono;

public interface IServiceMoneda {

    Mono<MonedaResponse> obtenerMonedas();


}
