package com.example.egas.com.service;

import com.example.egas.com.model.Moneda;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MiServicio {
    private final ServicioCliente servicioCliente;

    public Mono<List<Moneda>> obtenerDatos() {
        return servicioCliente.llamarAServicioExterno();
                //.doOnTerminate(() -> System.out.println("Llamada terminada"))
                //.onErrorResume(error -> Mono.just("Error al obtener los datos")
                 //       .map(s -> Arrays.asList(s.split(" "))));
    }
}
