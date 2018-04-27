package com.example.demo.Controllers;

import com.example.demo.MyUser;
import com.example.demo.services.UserService;
import com.example.demo.services.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;


@Controller

public class HomeController {



    private UserService userService=new UserServiceImp();

    public HomeController() throws FileNotFoundException {
    }


    @RequestMapping(value = {"index"}, method = RequestMethod.GET)
    public String index (Model model){
        model.addAttribute("user", new MyUser("username", "password"));
        return "index";
    }




    @RequestMapping(value = "index", method = RequestMethod.POST)
    public String login(@ModelAttribute MyUser user, Model model) {

        user = userService.getUser(user.getUsername(), user.getPassword());
        if (user != null) {
            return "homepage";
        }
        model.addAttribute("error", true);
        model.addAttribute("logout", true);
        return "index";

    }



    @RequestMapping(value = ("/homepage"), method = RequestMethod.GET)
    public String Create(Model model) {
        return "homepage";

    }


    @RequestMapping(value = ("forgotPassword"), method = RequestMethod.GET)
    public String forgotPassword(Model model) {
        return "forgotPassword";

    }

    File file = new File("test1002.txt");
    FileOutputStream d = new FileOutputStream(file);




}

