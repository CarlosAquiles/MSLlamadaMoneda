package com.example.egas.com.service.Implementacion;

import com.example.egas.com.model.Moneda;
import com.example.egas.com.response.CambioRequest;
import com.example.egas.com.response.CambioResponse;
import com.example.egas.com.response.MonedaResponse;
import com.example.egas.com.service.IServiceMoneda;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplServiceMoneda implements IServiceMoneda {


    @Override
    public Mono<MonedaResponse> obtenerMonedas() {

        return Mono.just(obtenerMonedas2())
                .map(monedas -> new MonedaResponse(monedas));
    }

    private List<Moneda> obtenerMonedas2(){

        List<Moneda> listaMoneda = new ArrayList();

        Moneda moneda1 = new Moneda();
        moneda1.setCodMoneda("01");
        moneda1.setDesMoneda("soles");
        //moneda1.setValMoneda("1");

        Moneda moneda2 = new Moneda();
        moneda2.setCodMoneda("02");
        moneda2.setDesMoneda("dolares");
        //moneda2.setValMoneda("3");

        Moneda moneda3 = new Moneda();
        moneda3.setCodMoneda("03");
        moneda3.setDesMoneda("euros");
        //moneda3.setValMoneda("4");

        listaMoneda.add(moneda1);
        listaMoneda.add(moneda2);
        listaMoneda.add(moneda3);

        return listaMoneda;

    }

}
