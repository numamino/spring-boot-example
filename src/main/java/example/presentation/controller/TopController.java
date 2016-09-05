package example.presentation.controller;

import example.application.service.UserService;
import example.domain.model.user.UserSummaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
class TopController {

    @Autowired
    UserService userService;


    @ModelAttribute("users")
    UserSummaries users() {
        return userService.list();
    }

    @RequestMapping
    String show() {
        return "top";
    }

}
