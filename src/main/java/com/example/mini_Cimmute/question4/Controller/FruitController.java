package com.example.mini_Cimmute.question4.Controller;

import com.example.mini_Cimmute.question4.Service.FruitService;
import com.example.mini_Cimmute.question4.dto.Fruit;
import com.example.mini_Cimmute.question4.dto.FruitResponse;
import com.example.mini_Cimmute.question4.dto.FruitAmount;
import com.example.mini_Cimmute.request.FruitSaveRequest;
import com.example.mini_Cimmute.request.FruitUpdate_Is_Sale;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService; //Spring 컨테이너가 대신 받게 해줌
    }

    @PostMapping("/api/v1/fruit")//body-name,warehousingDate,price
    public void saveFruit(@RequestBody FruitSaveRequest request) { //과일 저장
        fruitService.FruitSave(request);
    }

    @GetMapping("/api/v1/fruit")
    public List<FruitResponse> getFruit() {
        return fruitService.FruitGet();
    }

    @PutMapping("/api/v1/fruit") //body-id
    public void updateis_sale(@RequestBody FruitUpdate_Is_Sale request) {
        fruitService.Update_is_Sale(request);
    }

    @GetMapping("/api/v1/fruit/start")
    public List<FruitAmount> Amount(@RequestParam String name){
        return fruitService.FT(name);
    }

    @DeleteMapping("/api/v1/fruit")
    public void delete_fruit(@RequestParam long id){
        fruitService.FruitDelete(id);
    }
}