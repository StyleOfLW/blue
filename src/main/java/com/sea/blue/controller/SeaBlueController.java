package com.sea.blue.controller;

import com.sea.blue.model.SeaBlueProduct;
import com.sea.blue.model.Vaccine;
import com.sea.blue.servcie.SeaBlueService;
import com.sea.blue.servcie.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

@Controller
public class SeaBlueController
{
    @Autowired
    private SeaBlueService seaBlueService;

    @Autowired
    private VaccineService vaccineService;

    @GetMapping("/showAllSeaBlue")
    public String showAllSeaBlue(Model model)
    {
        model.addAttribute("seaBlueList", seaBlueService.getAllSeaBlue());

        List<String> dateList = seaBlueService.getAllDateList();
        List<String> herdList = seaBlueService.getAllHerdsList();

        model.addAttribute("dateList", dateList);
        model.addAttribute("herdList", herdList);
        model.addAttribute("seaBlueProduct", seaBlueService.getAllSeaBlue().get(0));
        return "seaBluePage";
    }

    @RequestMapping(value = "/searchSeaBlueProductByDate" , method= RequestMethod.POST)
    public String searchSeaBlueProductByDate(@ModelAttribute(value="seaBlueDate")SeaBlueProduct seaBlueProduct, Model model)
    {
        model.addAttribute("seaBlueList", seaBlueService.getAllSeaBlue());

        List<String> dateList = seaBlueService.getAllDateList();
        List<String> herdList = seaBlueService.getAllHerdsList();

        model.addAttribute("dateList", dateList);
        model.addAttribute("herdList", herdList);

        String date = seaBlueProduct.getDate().trim();
        model.addAttribute("seaBlueProduct", seaBlueService.findByDate(date));
        return  "seaBluePage";
    }

    @GetMapping("/showSubmitForm")
    public String showSubmitForm(Model model)
    {
        List<Vaccine> vaccines  = vaccineService.getAllVaccineList();
        model.addAttribute("vaccines", vaccines);
        return "showSubmitForm";
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request, HttpServletResponse resp ,Model model)
    {
        String pathInfo = request.getPathInfo();
        model.addAttribute("seaBlueUrl", "http://localhost:8080/showAllSeaBlue" + pathInfo);  //todo: request path
        return "home";
    }
}
