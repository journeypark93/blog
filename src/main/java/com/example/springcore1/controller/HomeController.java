package com.example.springcore1.controller;

import com.example.springcore1.model.UserRoleEnum;
import com.example.springcore1.security.UserDetailsImpl;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.TimeZone;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/home")
    public String userHome(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());

        if(userDetails.getUser().getRole() == UserRoleEnum.USER){
            model.addAttribute("user_role", true);
        }
        return "index";
    }

    //USER 만 접근가능~~
    @Secured("ROLE_USER")
    @GetMapping("/write")
    public String write(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        model.addAttribute("username", userDetails.getUsername());

        return "write";
    }

    @GetMapping("/blogs/comment/view")
    public String viewComment(){

        return "comment";
    }


    @GetMapping("/blogs/comment")
    public String comment(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        model.addAttribute("username", userDetails.getUsername());

        if(userDetails.getUser().getRole() == UserRoleEnum.USER){
            model.addAttribute("user_role", true);
        }
        return "comment";
    }

    //우리나라시간 변경
    @PostConstruct
    public void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }
}

