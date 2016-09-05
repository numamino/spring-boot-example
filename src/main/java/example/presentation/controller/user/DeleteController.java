package example.presentation.controller.user;

import example.application.service.UserService;
import example.domain.model.user.User;
import example.domain.model.user.UserIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/user/delete")
@SessionAttributes("user")
public class DeleteController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    String clearSessionAttribute(SessionStatus sessionStatus, @RequestParam(value="userId") String userId) {
        sessionStatus.setComplete();
        return "forward:/user/delete/" +userId + "/confirm";
    }

    @RequestMapping(value="/{userId}/confirm", method = RequestMethod.GET)
    String input(@PathVariable(value="userId") String userId, Model model) {
        User user = userService.findById(new UserIdentifier(userId));
        model.addAttribute("user", user);
        return "user/delete/confirm";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    String execute(@ModelAttribute User user, SessionStatus status) {
        userService.delete(user);
        status.setComplete();
        return "user/delete/result";
    }

}
