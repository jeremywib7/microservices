package com.fang.microservices.currencyexchangeservice.controllers;

import com.fang.microservices.currencyexchangeservice.models.CurrencyExchange;
import com.fang.microservices.currencyexchangeservice.services.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private final Environment environment;

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }

}
