package com.example.skyprocoursework3.controller;

import com.example.skyprocoursework3.dto.SocksDto;
import com.example.skyprocoursework3.model.Socks;
import com.example.skyprocoursework3.service.SocksSevice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/socks")
public class SocksController {

  private  final SocksSevice socksSevice;

    public SocksController(SocksSevice socksSevice) {
        this.socksSevice = socksSevice;
    }


    @PostMapping("/api/socks")
    public ResponseEntity<String> registerIncome(@RequestBody Socks socks) {
        try {
            // добавление партии носков на склад
            socksSevice.addSocks(socks);
            return ResponseEntity.ok("Приход успешно зарегистрирован.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/socks")
    public ResponseEntity<String> getSocksQuantity(@RequestParam String color,
                                                   @RequestParam Integer size,
                                                   @RequestParam Integer cottonPartMin,
                                                   @RequestParam Integer cottonPartMax) {
        try {
            int quantity = socksSevice.getQuantity(color, size, cottonPartMin, cottonPartMax);
            return ResponseEntity.ok().body(String.valueOf(quantity));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred.");
        }
    }

    @PostMapping("/socks/write-off")
    public ResponseEntity delSocks(@RequestBody Socks socks){
        ArrayList<Socks> socksArrayList = socksSevice.deleteSocks(socks);
        if (socksArrayList == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(socksArrayList);
    }

}
