package com.sea.blue.dao;

import com.sea.blue.model.SeaBlueProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeaBlueProductRepo extends CrudRepository<SeaBlueProduct,Long>
{
    @Query("select e from SeaBlueProduct e where e.date = ?1")
    SeaBlueProduct findByDate(String date);
}
