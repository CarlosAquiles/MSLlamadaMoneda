package com.example.egas.com.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CambioRequest {
    private Integer    idMoneda;
    private BigDecimal totalCambio;
}
