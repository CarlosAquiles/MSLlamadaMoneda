package com.example.egas.com.controller;


import com.example.egas.com.response.CambioRequest;
import com.example.egas.com.response.CambioResponse;
import com.example.egas.com.response.MonedaResponse;
import com.example.egas.com.service.IServiceCliente;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webClient")
@RequiredArgsConstructor
public class MonedaController {

    private final IServiceCliente servicioCliente;

    @GetMapping("/listarMoneda")
    public Mono<MonedaResponse> listarMoneda() {
        return servicioCliente.listarMoneda();
    }

    @GetMapping("/obtenerCambio/{idMoneda}/{cantidad}")
    public Mono<CambioResponse> obtenerCambio(@PathVariable Integer idMoneda, @PathVariable Integer cantidad) {
        return servicioCliente.obtenerCambio(idMoneda, cantidad);
    }

    @PostMapping("/obtenerCambio2")
    public Mono<CambioResponse> obtenerCambio2(@RequestBody CambioRequest cambioRequest) {
        return servicioCliente.obtenerCambio2(cambioRequest);
    }

    @GetMapping("/obtenerCambio3")
    public Mono<CambioResponse> obtenerCambio3(@RequestParam Integer idMoneda, @RequestParam Integer cantidad) {
        return servicioCliente.obtenerCambio3(idMoneda, cantidad);
    }
}
