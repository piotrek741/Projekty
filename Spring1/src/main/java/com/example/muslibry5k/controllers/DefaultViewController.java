package com.example.muslibry5k.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class DefaultViewController {

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

}
