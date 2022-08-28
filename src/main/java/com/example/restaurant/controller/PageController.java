package com.example.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {

    @GetMapping("/main")
    // ModelAndView : 타임리프에서 특정한 html view로 보낸때 사용
    public ModelAndView main(){
        return new ModelAndView("main");
        // ModelAndView("main") 에서 main은 templates의 하위
        // ex) template.aaaa에 main.html이 들어가 있으면 ModelAndView("aaaa/main")
    }
}
