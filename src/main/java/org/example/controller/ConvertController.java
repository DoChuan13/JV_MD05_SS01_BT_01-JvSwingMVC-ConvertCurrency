package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    String RESULT = "result", TYPE = "type", VALUE = "value", RATE = "rate";

    @GetMapping(value = "/")
    public String showFormConvertCurrency(Model model) {
        model.addAttribute(RESULT, "waiting");
        return "convert";
    }

    @GetMapping(value = "/convert")
    public String ConvertCurrency(@RequestParam String type, Float value, Float rate, Model model) {
        float result = 0;
        System.out.println(type);
        System.out.println(value);
        System.out.println(rate);
        if (value != null && rate != null) {
            model.addAttribute(TYPE, type);
            model.addAttribute(VALUE, value);
            model.addAttribute(RATE, rate);
            switch (type) {
                case "usd" -> {
                    result = value * rate;
                    model.addAttribute(RESULT, Float.valueOf(result).longValue());
                    return "convert";
                }
                case "vnd" -> {
                    if (rate == 0) {
                        model.addAttribute(RESULT, "Rate Value is 0");
                    } else {
                        result = value / rate;
                        model.addAttribute(RESULT, Float.valueOf(result).longValue());
                    }
                    return "convert";
                }
            }
        } else {
            model.addAttribute(RESULT, "Blank Filed!!! Please try again");
            return "convert";
        }
        System.out.println(result);
        return "convert";
    }
}
