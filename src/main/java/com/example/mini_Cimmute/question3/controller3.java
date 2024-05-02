package com.example.mini_Cimmute.question3;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class controller3 {
    @PostMapping("/sum")
    public int sum(@RequestBody request request) {
        List<Integer> numbers = request.getNumbers();
        int sum = 0;
        for (int number : numbers) {
            sum += number;

        }
        return sum;
    }
}
