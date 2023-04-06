package com.example.skyprocoursework3.model;

public enum CottonPercentage {

    C(0),
    C10(10),
    C20(20),
    C50(50),
    C90(90),
    C100(100);

    private final int percentage;

    CottonPercentage(int percentage) {
        this.percentage = percentage;
    }




    public int getPercentage() {
        return percentage;
    }
}
