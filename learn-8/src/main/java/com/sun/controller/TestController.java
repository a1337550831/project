package com.sun.controller;

import com.sun.pojo.Content;
import com.sun.pojo.Student;
import com.sun.service.ContentService;
import com.sun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ContentService contentService;

    @RequestMapping("/a/index")
    public String getIndex(Model model){
        List<Content> contentList = contentService.selectByParam(2);
        List<Student> studentList = studentService.selectByParam(1);
        model.addAttribute("contentList",contentList);
        model.addAttribute("studentList",studentList);
        return "index";
    }

}
