package com.example.skyprocoursework3.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


public class Socks {
    private SocksColor socksColor;
    private SocksSize socksSize;
    private  final int cottonPercentage;


    public Socks(SocksColor socksColor, SocksSize socksSize, int cottonPercentage) {
        this.socksColor = socksColor;
        this.socksSize = socksSize;
        this.cottonPercentage = cottonPercentage;
    }

    public SocksColor getSocksColor() {
        return socksColor;
    }

    public SocksSize getSocksSize() {
        return socksSize;
    }

    public int getCottonPercentage() {
        return cottonPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socks socks = (Socks) o;
        return cottonPercentage == socks.cottonPercentage && socksColor == socks.socksColor && socksSize == socks.socksSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(socksColor, socksSize, cottonPercentage);
    }


    public SocksColor setSocksColor() {
     return     socksColor;
    }

    public SocksSize getSize() {
       return socksSize;
    }

    public int getMaterial() {
        return 0;
    }

    public Integer getQuantity() {
        return 0;
    }
}
