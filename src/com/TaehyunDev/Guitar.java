package com.TaehyunDev;

import com.TaehyunDev.Instrument.Instrument;
import lombok.Getter;

public class Guitar extends Instrument {

    @Getter
    private String serialNumber;
    @Getter
    private double price;
    @Getter
    GuitarSpec spec;

    public Guitar(String serialNumber, double price, GuitarSpec spec) {
        super(serialNumber, price, spec);
    }
}
