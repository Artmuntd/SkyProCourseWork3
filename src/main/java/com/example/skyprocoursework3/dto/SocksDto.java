package com.example.skyprocoursework3.dto;

import com.example.skyprocoursework3.model.SocksColor;
import com.example.skyprocoursework3.model.SocksSize;

public class SocksDto {
    private SocksColor socksColor;
    private SocksSize socksSize;
    private  int cottonPercentage;
    private  int quantity;

    public SocksColor getSocksColor() {
        return socksColor;
    }

    public void setSocksColor(SocksColor socksColor) {
        this.socksColor = socksColor;
    }

    public SocksSize getSocksSize() {
        return socksSize;
    }

    public void setSocksSize(SocksSize socksSize) {
        this.socksSize = socksSize;
    }

    public int getCottonPercentage() {
        return cottonPercentage;
    }

    public void setCottonPercentage(int cottonPercentage) {
        this.cottonPercentage = cottonPercentage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
