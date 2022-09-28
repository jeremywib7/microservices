package com.fang.microservices.currencyexchangeservice.services;

import com.fang.microservices.currencyexchangeservice.models.CurrencyExchange;
import com.fang.microservices.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CurrencyExchangeService {

    private final Environment environment;

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchange retrieveExchangeValue(String from, String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to).orElseThrow(
                () -> new RuntimeException("Unable to Find data for " + from + " to " + to)
        );
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return  currencyExchange;
    }
}
