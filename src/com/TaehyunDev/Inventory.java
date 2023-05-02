package com.TaehyunDev;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List<Guitar> guitars;
    public Inventory() {
        guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, double price,GuitarSpec spec) {
        Guitar guitar = new Guitar(serialNumber, price, spec);
        guitars.add(guitar);
    }

    public List<Guitar> search(GuitarSpec searchSpec) {
        List<Guitar> matchingGuitars = new LinkedList<>();
        for (Guitar guitar : guitars) {
            if (searchSpec.matches(guitar.getSpec())){
                matchingGuitars.add(guitar);
            }
        }
        return matchingGuitars;
    }
}
