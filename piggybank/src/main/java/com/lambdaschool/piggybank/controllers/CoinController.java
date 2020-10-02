package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinController
{
    @Autowired
    CoinRepository cnrepos;

    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> listCoins()
    {
        // logging out response rather than sending
        // it over postman...
        double total = 0;
        for (Coin c : cnrepos.findAll())
        {
            total += c.getQuantity() * c.getValue();
            System.out.println((c.getQuantity() == 1)
                    ? (c.getQuantity() + " " + c.getName())
                    : (c.getQuantity() + " " + c.getNameplural()));
        }
        System.out.println("The piggy bank holds " + total);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
