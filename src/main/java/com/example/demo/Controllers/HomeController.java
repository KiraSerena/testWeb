package com.example.demo.Controllers;

import com.example.demo.MyUser;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


@Controller

public class HomeController {



    private UserService userService= new UserService() {
        @Override
        public MyUser getUser(String username, String password) {
            return null;
        }
    };

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

