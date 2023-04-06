package com.example.skyprocoursework3.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SocksSize {
    XS(33),
    S(36),
    M(38),
    L(41),
    XL(46);



    private  final  int maxSize;

    SocksSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @JsonCreator
    public  static  SocksSize convertSize(int value){
        for ( SocksSize socksSize : SocksSize.values()){
            if (value == socksSize.maxSize){
                return socksSize;
            }
        }
        throw  new RuntimeException("Нет размера");
    }
}
