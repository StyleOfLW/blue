package com.sea.blue.servcie;

import com.sea.blue.dao.SeaBlueProductRepo;
import com.sea.blue.model.SeaBlueProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class SeaBlueService
{
    @Autowired
    private SeaBlueProductRepo seaBlueDao;

    public List<SeaBlueProduct> getAllSeaBlue()
    {
        return (List<SeaBlueProduct>) seaBlueDao.findAll();
    }

    public List<String> getAllDateList()
    {
//        List<String> dateList =seaBlueDao.findByDate();
//        return dateList;
        Iterable<SeaBlueProduct> all = seaBlueDao.findAll();
        List<String> dateList = new LinkedList<>();
        for (SeaBlueProduct seaBlueProduct : all)
        {
            dateList.add(seaBlueProduct.getDate());
        }
        return dateList;
    }

    public List<String> getAllHerdsList()
    {
        Iterable<SeaBlueProduct> all = seaBlueDao.findAll();
        List<String> dateList = new LinkedList<>();
        for (SeaBlueProduct seaBlueProduct : all)
        {
            dateList.add(seaBlueProduct.getHerds());
        }
        return dateList;
    }

    public SeaBlueProduct findByDate(String date)
    {
        return Optional.ofNullable(seaBlueDao.findByDate(date)).orElse(new SeaBlueProduct());
    }
}
