package edu.miu.nomin.jpa.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
    @GetMapping({"/", "/home", "/elibrary"} )
    public String homePage() {
        return "home/index";
    }
}
