package org.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String getHomePage(){
        return "/home/index";
    }

//    @GetMapping("/lang={lan}")
//    public ModelAndView getLanguage(@PathVariable("lan") String lan){
//        ModelAndView modelAndView = new ModelAndView("/home/index");
//        modelAndView.addObject("lang", lan);
//        return modelAndView;
//    }
}
