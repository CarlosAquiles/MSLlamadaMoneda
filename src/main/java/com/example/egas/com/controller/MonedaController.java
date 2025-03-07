package com.example.egas.com.controller;


import com.example.egas.com.response.CambioResponse;
import com.example.egas.com.response.MonedaResponse;
import com.example.egas.com.service.ServicioCliente;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MonedaController {

    //private final IServiceMoneda iServiceMoneda;

    /*
    @GetMapping("/mono")
    public Mono<MonedaResponse> getListarMoneda() {
        MonedaResponse monedaResponse = new MonedaResponse();

        return iServiceMoneda.listarMoneda();
    }
    */

    private final ServicioCliente servicioCliente;

    @GetMapping("/obtener-datos")
    public Mono<MonedaResponse> obtenerDatos() {
        return servicioCliente.listarMoneda();
    }

    @GetMapping("/obtener-valor/{idMoneda}/{cantidad}")
    public Mono<CambioResponse> obtenerValor(@PathVariable Integer idMoneda, @PathVariable Integer cantidad) {
        return servicioCliente.obtenerValor(idMoneda, cantidad);
    }
}
