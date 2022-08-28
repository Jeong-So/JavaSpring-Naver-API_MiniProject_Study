package com.example.restaurant.wishlist;

import com.example.restaurant.db.MemoryDbRepositoryAbstract;
import com.example.restaurant.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository  // db를 저장하는 곳이라는 의미의 어노테이션
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
    // 추 후 JPA 적용해서 MemoryDbRepositoryAbstract --> JpaRepository 로 변경
}
