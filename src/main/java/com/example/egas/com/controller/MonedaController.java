package com.example.egas.com.controller;

import com.example.egas.com.model.Moneda;
import com.example.egas.com.response.MonedaResponse;
import com.example.egas.com.service.IServiceMoneda;
import com.example.egas.com.service.MiServicio;
import com.example.egas.com.service.ServicioCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

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

    private final ServicioCliente miServicio;

    @GetMapping("/obtener-datos")
    public Mono<List<Moneda>> obtenerDatos() {
        return miServicio.llamarAServicioExterno();
    }
}
