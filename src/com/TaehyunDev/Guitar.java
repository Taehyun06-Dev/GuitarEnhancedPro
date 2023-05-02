package com.TaehyunDev;

import lombok.Getter;

public class Guitar {

    @Getter
    private String serialNumber;
    @Getter
    private double price;
    @Getter
    GuitarSpec spec;

    public Guitar(String serialNumber, double price, GuitarSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }
}
