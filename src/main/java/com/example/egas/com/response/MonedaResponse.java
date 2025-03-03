package com.example.egas.com.response;

import com.example.egas.com.model.Moneda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonedaResponse {

    private List<Moneda> listaMoneda;

}


