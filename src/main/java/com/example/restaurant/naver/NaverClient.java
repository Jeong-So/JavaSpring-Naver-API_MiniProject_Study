package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchImageRes;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {

    @Value("${naver.client.id}")
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverClientSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq){

        // 요청하는 주소 만듬
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
//                .queryParam("query", "sfesf")  // queryParam 각각 넣는 방법
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        // header 준비
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // request 준비
        var httpEntity = new HttpEntity<>(headers);
        // response Type 준비
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){};

        // RestTemplate 통해서 결과(uri/header/ request/response) 얻어옴
        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );

        // getBody 통해 결과 return
        return responseEntity.getBody();

    }

    public SearchImageRes searchImage(SearchImageReq searchImageReq){

        // 요청하는 주소 만듬
        var uri = UriComponentsBuilder.fromUriString(naverImageSearchUrl)
//                .queryParam("query", "sfesf")  // queryParam 각각 넣는 방법
                .queryParams(searchImageReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        // header 준비
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // request 준비
        var httpEntity = new HttpEntity<>(headers);
        // response Type 준비
        var responseType = new ParameterizedTypeReference<SearchImageRes>(){};

        // RestTemplate 통해서 결과(uri/header/ request/response) 얻어옴
        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );

        // getBody 통해 결과 return
        return responseEntity.getBody();

    }


}
