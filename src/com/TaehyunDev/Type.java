package com.TaehyunDev;

public enum Type {
    ACOUSTIC, ELECTRIC, CLASSIC, N;

    public String toString() {
        switch (this) {
            case ACOUSTIC:
                return "Acoustic";
            case ELECTRIC:
                return "Electric";
            case CLASSIC:
                return "Classic";
            default:
                return "Unkown";
        }
    }
}