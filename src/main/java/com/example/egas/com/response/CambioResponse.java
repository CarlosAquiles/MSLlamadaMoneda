package com.example.egas.com.response;

import com.example.egas.com.model.Moneda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CambioResponse {

    private Moneda moneda;
    private BigDecimal totalCambio;
}
