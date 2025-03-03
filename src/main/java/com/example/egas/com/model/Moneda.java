package com.example.egas.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Moneda {

    private Integer idMoneda;
    private String desMoneda;
    private String  codMoneda;
    private BigDecimal valMoneda;

}
