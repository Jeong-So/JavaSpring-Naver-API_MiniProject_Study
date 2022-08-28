package com.example.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static java.lang.String.valueOf;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchLocalReq {

    // 요청변수
    private String query = "";

    private int display = 1;

    private int start = 1;

    private String sort = "random";


    // queryParams에 한번에 넣도록 map 만듬
    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();

        map.add("query", query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort", sort);

        return map;
    }
}
