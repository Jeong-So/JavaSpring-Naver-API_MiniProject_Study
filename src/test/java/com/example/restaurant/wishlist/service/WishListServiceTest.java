package com.example.restaurant.wishlist.service;

import com.example.restaurant.wishlist.dto.WishListDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListServiceTest {

    // 원래: search를 바로 테스트하는게 아닌
    // search의 NaverClient가 @Autowired DI로 받고 있음
    // NaverClient를 목킹처리를 해서 결과를 내려준다고 만들어준 후에
    // 내가 원하는 result가 잘 만들어지는지 Test 코드로 비교

    @Autowired
    private WishListService wishListService;

    @Test
    public void searchTest(){
        var result = wishListService.search("갈비집");

        System.out.println(result);
        Assertions.assertNotNull(result);
    }
}
