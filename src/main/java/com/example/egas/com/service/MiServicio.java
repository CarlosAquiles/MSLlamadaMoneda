package com.example.egas.com.service;

import com.example.egas.com.model.Moneda;
import com.example.egas.com.service.Implementacion.ImplServicioCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


import java.util.List;

@Service
@RequiredArgsConstructor
public class MiServicio {
    private final ImplServicioCliente servicioCliente;

    public Mono<List<Moneda>> obtenerDatos() {
        return null;
                //.doOnTerminate(() -> System.out.println("Llamada terminada"))
                //.onErrorResume(error -> Mono.just("Error al obtener los datos")
                 //       .map(s -> Arrays.asList(s.split(" "))));
    }
}
