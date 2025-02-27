package com.example.kriptorep4ik.logic;

public class CurrencyRate {
    private final String letter_code;
    private final String unit;
    private final String currency;
    private final String rate;

    public CurrencyRate(String letter_code, String unit, String currency, String rate)
    {
        this.letter_code = letter_code;
        this.unit = unit;
        this.currency = currency;
        this.rate = rate;
    }
}

