package com.example.egas.com.service;

import com.example.egas.com.response.CambioRequest;
import com.example.egas.com.response.CambioResponse;
import com.example.egas.com.response.MonedaResponse;
import reactor.core.publisher.Mono;


public interface IServiceCliente {

    Mono<MonedaResponse> listarMoneda();

    Mono<CambioResponse> obtenerCambio(Integer idMoneda, Integer cantidad);

    Mono<CambioResponse> obtenerCambio2(CambioRequest cambioRequest);

    Mono<CambioResponse> obtenerCambio3(Integer idMoneda, Integer cantidad);
}
