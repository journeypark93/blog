package com.example.springcore1.controller;

import com.example.springcore1.model.UserRoleEnum;
import com.example.springcore1.security.UserDetailsImpl;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());

        if(userDetails.getUser().getRole() == UserRoleEnum.ADMIN){
            model.addAttribute("admin_role", true);
        }
        return "index";
    }

    //USER 만 접근가능~~
    @Secured("ROLE_USER")
    @GetMapping("/write")
    public String write(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        model.addAttribute("username", userDetails.getUsername());

//        if(userDetails.getUser().getRole() != "USER") {
//            return "index";
//        }
        return "write";
    }

    @GetMapping("/blogs/comment")
    public String comment(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        model.addAttribute("username", userDetails.getUsername());
        return "comment";
    }
}

