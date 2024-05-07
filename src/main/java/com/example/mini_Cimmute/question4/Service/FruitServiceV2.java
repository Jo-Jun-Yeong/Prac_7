package com.example.mini_Cimmute.question4.Service;

import com.example.mini_Cimmute.question4.domain.Fruit;
import com.example.mini_Cimmute.question4.domain.FruitRepository;
import com.example.mini_Cimmute.question4.dto.FruitResponse;
import com.example.mini_Cimmute.question4.request.FruitUpdate_Is_Sale;
import com.example.mini_Cimmute.question4.request.Fruit_Delete;
import com.example.mini_Cimmute.question4.request.Fruit_Is_Sale;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class FruitServiceV2 {
    private final FruitRepository fruitRepository;


    public FruitServiceV2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void FruitsSave(Fruit request){
        fruitRepository.save(new Fruit(request.getId(),request.getName(), request.getWarehousing_date(), request.getPrice(), request.isIs_sale()));
    }
    public List<FruitResponse> FruitGet(){
//        List<Fruit> fruits=  //select * from fruit;
                return fruitRepository.findAll().stream().
                map(
                        FruitResponse::new
                ).collect(Collectors.toList());
        //fruit -> fruitResponse로 변화
    }

    public List<Fruit_Is_Sale> Fruit_is_sale(Fruit_Is_Sale request) {
        fruitRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
           return fruitRepository.findById(request.getId()).stream().map(
                fruit -> new Fruit_Is_Sale(request.getId())
           ).collect(Collectors.toList());
//           findById -> select * from fruit where id = ?;
    }

    public void FruitDelete(Fruit_Delete request){
       Fruit fruit= fruitRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        fruitRepository.delete(fruit);
        //delete fruit where id = ?;
    }
//    public List<FruitAmount> FruitTest(String name){}
    public void Fruit_Sale(FruitUpdate_Is_Sale request) {
        Fruit fruit = fruitRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        fruit.do_is_sale(fruit.isIs_sale());
        fruitRepository.save(fruit);
    }
}
