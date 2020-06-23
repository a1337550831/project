package com.sun.controller;

import com.sun.service.ContentService;
import com.sun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ContentService contentService;

    @RequestMapping("/a/index")
    public String getIndex(Model model){
//        List<Content> contentList = contentService.selectByParam(2);
//        List<Student> studentList = studentService.selectByParam(1);
//        model.addAttribute("contentList",contentList);
//        model.addAttribute("studentList",studentList);
        model.addAttribute("name","小茗同学");
        return "myTest";
    }

}
