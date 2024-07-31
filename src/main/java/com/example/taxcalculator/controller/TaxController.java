package com.example.taxcalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.taxcalculator.service.TaxService;


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
        try {
            if (income < 0) {
                throw new IllegalArgumentException("Income cannot be negative.");
            }
            double tax = taxService.calculateTax(income);
            model.addAttribute("income", income);
            model.addAttribute("tax", tax);
            return "result";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }

    @PostMapping("/calculatewithAge")
    public String calculateWithAge(@RequestParam("income2") double income2, @RequestParam("age") int age, @RequestParam("additional") double additional, @RequestParam("deduction") double deduction, Model model) {
        try {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative.");
            }
            if (income2 < 0) {
                throw new IllegalArgumentException("Income must be greater than 0.");
            }
            double tax2 = TaxService.calculateTaxAge(income2, age, additional, deduction);
            model.addAttribute("income2", income2);
            model.addAttribute("age", age);
            model.addAttribute("additional", additional);
            model.addAttribute("deduction", deduction);
            model.addAttribute("tax2", tax2);
            return "result";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "index";
    }
}
