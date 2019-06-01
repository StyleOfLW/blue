package com.sea.blue.servcie;

import com.sea.blue.dao.VaccineRepo;
import com.sea.blue.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineService
{
    @Autowired
    private VaccineRepo vaccineRepo;

    public List<Vaccine> getAllVaccineList()
    {
        return (List<Vaccine>) vaccineRepo.findAll();
    }
}
