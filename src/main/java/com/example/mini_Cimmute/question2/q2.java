package com.example.mini_Cimmute.question2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.time.*;

/*날짜를 입력하면 몇요일인지 알려주는 get api만들기
* path와 쿼리는 피라미터는 임의 상관 없음*/
@RestController
public class q2 {
    @GetMapping("/dayofweek")
    public String day_of_week(@RequestParam String dayofweek){
//        String dayofweek;
        LocalDate currentDate = LocalDate.parse(dayofweek);
        dayofweek=currentDate.getDayOfWeek().toString();
        // 현재 날짜의 요일 가져오기


        // 요일 문자열로 변환하여 반환
        return dayofweek;

    }


}
