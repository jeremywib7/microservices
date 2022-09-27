package com.fang.microservices.currencyexchangeservice.models;

import lombok.*;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {
    @NonNull
    private Long id;

    @NonNull
    private String from;

    @NonNull
    private String to;

    @NonNull
    private BigDecimal conversionMultiple;

    private String environment;
}
