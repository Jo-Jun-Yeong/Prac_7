package com.example.mini_Cimmute.question4.Repository;

import com.example.mini_Cimmute.question4.domain.Fruit;
import com.example.mini_Cimmute.question4.dto.FruitAmount;
import com.example.mini_Cimmute.question4.dto.FruitResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FruitJdbcRepository {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public FruitJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void FruitsSave(String name, LocalDate warehousingDate, long price){
        String sql = "insert into fruit(name, warehousingDate, price) values (?,?,?)";
        jdbcTemplate.update(sql, name, warehousingDate, price);
    }

    public List<FruitResponse> FruitGet(){
        String sql = "select * from fruit";
        //mapRow -> jdbc의 쿼리가 sql을 수행할  fruit정보를 가지고있을떄  fruit(테이블)의 정보를 fruitresponse로 바꿔주는 역할을 한다.
//13강 16분 10초
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            LocalDate warehousingDate = rs.getDate("warehousingDate").toLocalDate();
            long price = rs.getLong("price");
            boolean is_sale = rs.getBoolean("is_sale");
            return new FruitResponse(new Fruit(id, name, warehousingDate, price,is_sale ));
        });
    }

    public void Fruitis_sale(boolean is_sale){//판매된 과일의 is_sale의 상태 변경
        String sql = "update fruit set is_sale= not is_sale where id= ?";
        jdbcTemplate.update(sql, is_sale);
    }

    public void FruitDelete(long id){
        String sql = "delete from fruit where id = ?";
        jdbcTemplate.update(sql, id);
    }

    ////////////////////////////////////////////////////
    //문제점 인수를 받아 select하는 방법에서 막힘
    public List<FruitAmount> FruitAmount(String name){
        String sql = "select " +
                " sum(case when is_sale = 0 then price else 0 end) as notSalesAmount," +
                " sum(case when is_sale = 1 then price else 0 end) as salesAMount" +
                " from fruit where name = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long notSalesAMount = rs.getLong("notSalesAMount");
            long salesAmount = rs.getLong("salesAmount");
            return new FruitAmount(salesAmount, notSalesAMount);
        }, name);
    }
    ////////////////////////////////////////////////////

    public boolean is_Fruit_exist(long id) {
        String sql = "select * from fruit where id =?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 0, id).isEmpty();
    }
}
