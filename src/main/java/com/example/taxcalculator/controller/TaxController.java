package com.example.taxcalculator.controller;

import com.example.taxcalculator.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaxController {

    @Autowired
    private TaxService taxService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateTax(@RequestParam("income") double income, Model model) {
        double tax = taxService.calculateTax(income);
        model.addAttribute("income", income);
        model.addAttribute("tax", tax);
        return "result";
    }
}
