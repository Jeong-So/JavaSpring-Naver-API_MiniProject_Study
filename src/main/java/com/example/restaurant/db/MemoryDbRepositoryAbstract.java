package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {

    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
        // filter: db stream()에 들어있는 List<T> db 타입에 대한부분
        // it.getIndex() : MemoryDbEntity에 정의된 index를 의미
    }

    @Override
    public T save(T entity) {

        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if(optionalEntity.isEmpty()){
            // db에 데이터가 없는경우
            index++;
            entity.setIndex(index);
            db.add(entity);

            return entity;
        }else{
            // db에 이미 데이터가 있는 경우
            var preIndex  = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);

            return entity;
        }

    }

    @Override
    public void deleteById(int index) {

        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();
        if(optionalEntity.isPresent()){
            // db에 이미 데이터가 있는 경우
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> listAll() {
        return db;
    }

}
