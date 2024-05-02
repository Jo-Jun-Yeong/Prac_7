package com.example.mini_Cimmute.question;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calcContoller {
    @GetMapping("/sum")
    public Calc getcalc(@RequestParam int a1, @RequestParam int a2){
        int sum = a1+a2;
        int min=a1-a2;
        int multpl= a1*a2;

        return new Calc(sum, min, multpl);

    }
}
