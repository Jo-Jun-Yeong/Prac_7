package com.example.mini_Cimmute.question4.Service;

import com.example.mini_Cimmute.question4.Repository.FruitJdbcRepository;
import com.example.mini_Cimmute.question4.dto.Fruit;
import com.example.mini_Cimmute.question4.dto.FruitResponse;
import com.example.mini_Cimmute.question4.dto.FruitAmount;
import com.example.mini_Cimmute.request.FruitSaveRequest;
import com.example.mini_Cimmute.request.FruitUpdate_Is_Sale;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FruitService {
    private final FruitJdbcRepository fruitJdbcRepository;

    public FruitService(FruitJdbcRepository fruitRepository) {
        this.fruitJdbcRepository=fruitRepository;
    }
    public List<FruitResponse> FruitGet(){
        return fruitJdbcRepository.FruitGet();
    }
    public void FruitSave(FruitSaveRequest request){
        fruitJdbcRepository.FruitsSave(request.getName(), request.getWarehousingDate(), request.getPrice()); //과일 저장
    }

    public void FruitDelete(long id){
        if(fruitJdbcRepository.is_Fruit_exist(id)){
            throw new IllegalArgumentException("id를 체크해보세요");
        }
        fruitJdbcRepository.FruitDelete(id);
    }

    public void Update_is_Sale(FruitUpdate_Is_Sale request){
        fruitJdbcRepository.Fruitis_sale(request.isIs_sale());
    }
    public List<FruitAmount> FT(String request){
        return fruitJdbcRepository.FruitTest(request);
    }
}
