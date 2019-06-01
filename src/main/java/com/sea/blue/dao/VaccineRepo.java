package com.sea.blue.dao;

import com.sea.blue.model.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepo extends CrudRepository<Vaccine,Integer>
{
}
