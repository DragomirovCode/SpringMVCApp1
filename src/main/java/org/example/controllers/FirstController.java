package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "surname",required = false) String surname,
                           Model model){
        model.addAttribute("message","hello, " + name + " " + surname);
        return "first/hello";
    }
    @GetMapping("/calculator")
    public String sayCalculator(@RequestParam(value = "a",required = false) Integer a,
                                @RequestParam(value = "b",required = false) Integer b,
                                @RequestParam(value = "action",required = false) String action,
                                Model model) {
        switch (action) {
            case "multiplication":
                model.addAttribute("message", a * b);
                break;
            case "addition":
                model.addAttribute("message", a + b);
                break;
            case "subtraction":
                model.addAttribute("message", a - b);
                break;
            case "division":
                model.addAttribute("message", a / b);
                break;
            default:
                model.addAttribute("message", "null");
        }

        return "first/calculator";
    }
    @GetMapping("/goodbye")
    public String sayGoodbye(){
        return "first/goodbye";
    }
}
