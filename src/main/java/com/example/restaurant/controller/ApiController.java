package com.example.restaurant.controller;

import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController {

    // 서비스 연결
    private final WishListService wishListService;


    @GetMapping("/search")
    public WishListDto search(@RequestParam String query){
        return wishListService.search(query);
    }

    // WishList 추가
    @PostMapping("")
    public WishListDto add(@RequestBody WishListDto wishListDto){
        log.info("{}",wishListDto);

        return wishListService.add(wishListDto);
    }

    // WishList에 추가된 데이터 보이기
    @GetMapping("/all")
    public List<WishListDto> findAll(){
        return wishListService.findAll();
    }

    // WishList 삭제
    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){
        wishListService.delete(index);
    }

    // update 방문 시 visitcount (방문여부)
    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
        wishListService.addVisit(index);
    }
}
