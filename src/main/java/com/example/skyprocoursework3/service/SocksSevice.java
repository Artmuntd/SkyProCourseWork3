package com.example.skyprocoursework3.service;

import com.example.skyprocoursework3.dto.SocksDto;
import com.example.skyprocoursework3.model.Socks;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SocksSevice {


    private Map<Socks,Integer> socksMap = new HashMap<>();



    public void addSocks(Socks socksDto) {
        validateRequest(socksDto);
        Socks socks = mapToSocks(socksDto);
        if (socksMap.containsKey(socks)) {
            int currentQuantity = socksMap.get(socks);
            socksMap.put(socks, currentQuantity + socksDto.getQuantity());
        } else {
            socksMap.put(socks, socksDto.getQuantity());
        }
    }




    private void validateRequest(Socks socksDto) {
        if(socksDto.getSocksColor() == null || socksDto.getSocksSize() == null){
            throw new RuntimeException(("не правильный запрос"));
        }
        if(socksDto.getCottonPercentage()<0 || socksDto.getCottonPercentage() > 100){
            throw  new RuntimeException(" не правильный параметр");
        }
        if(socksDto.getQuantity()<= 0){
            throw  new RuntimeException("Нет носок на складе");
        }
    }


    private Socks mapToSocks(Socks socksDto) {
        return  new Socks(socksDto.getSocksColor(),socksDto.getSocksSize(),socksDto.getCottonPercentage());
    }


    public int getQuantity(String color, Integer size, Integer cottonPartMin, Integer cottonPartMax) {
        if (color == null || color.isEmpty() || size == null || cottonPartMin == null || cottonPartMax == null) {
            throw new IllegalArgumentException("Invalid request parameters");
        }


        int totalSocksCount = 0;

        for (Socks socks : socksMap.keySet()) {
            if (socks.getSocksColor().equals(color) && socks. getSocksSize().equals(size) && socks.getCottonPercentage() >= cottonPartMin && socks.getCottonPercentage() <= cottonPartMax) {
                totalSocksCount += socks.getQuantity();
            }
        }
        return totalSocksCount;
    }
    public  void delSocks(){
        socksMap = new TreeMap<>();

    }
}
