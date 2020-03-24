package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/test")
public class MyControllerOne {

    @RequestMapping("/controllerOne")
    //@ResponseBody
    public String controllerOne(){
        System.out.println("你看到我的返回了吗");
        return "redirect:index.jsp";
    }


    @PostMapping("/controllerTwo")
    public void controllerTwo(){

    }

    @GetMapping("/controllerThree")
    public void controllerThree(){

    }

    @PutMapping("/controllerFour")
    public void controllerFour(){

    }

    @DeleteMapping("/controllerSix")
    public void controllerFive(){

    }

    @PatchMapping("/controllerSeven")
    public void controllerSeven(){

    }

}
