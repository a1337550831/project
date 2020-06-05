package com.sun.controller;

import com.sun.serivce.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;



}
