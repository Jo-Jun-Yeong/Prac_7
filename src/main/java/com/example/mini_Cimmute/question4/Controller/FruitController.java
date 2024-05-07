package com.example.mini_Cimmute.question4.Controller;

import com.example.mini_Cimmute.question4.Service.FruitServiceV2;
import com.example.mini_Cimmute.question4.dto.FruitResponse;
import com.example.mini_Cimmute.question4.request.FruitUpdate_Is_Sale;
import com.example.mini_Cimmute.question4.request.Fruit_Delete;
import com.example.mini_Cimmute.question4.request.Fruit_Is_Sale;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FruitController {
//    private final FruitServiceV1 fruitService;
//        public FruitController(FruitServiceV1 fruitService) {
//        this.fruitService = fruitService; //Spring 컨테이너가 대신 받게 해줌
//    }

    private final FruitServiceV2 fruitService2;

    public FruitController(FruitServiceV2 fruitService2) {
        this.fruitService2 = fruitService2;
    }


//    @PostMapping("/api/v1/fruit")//body-name,warehousingDate,price
//    public void saveFruit(@RequestBody FruitSaveRequest request) { //과일 저장
//        fruitService.FruitSave(request);
//    }

    @GetMapping("/api/v1/fruit")
    public List<FruitResponse> getFruit() {
        return fruitService2.FruitGet();
    }

    @GetMapping("/api/v1/fruit/id")
    public List<Fruit_Is_Sale> update_is_sale(Fruit_Is_Sale request) {
        return fruitService2.Fruit_is_sale(request);
    }

//    @GetMapping("/api/v1/fruit/start")
//    public List<FruitAmount> Amount(@RequestParam String name){
//        return fruitService.FT(name);
//    }

    @DeleteMapping("/api/v1/fruit")
    public void delete_fruit(Fruit_Delete request){
        fruitService2.FruitDelete(request);
    }

    @PutMapping("/api/v1/fruit/sale")
    public void Fruit_Sale(FruitUpdate_Is_Sale request){
        fruitService2.Fruit_Sale(request);
    }
}