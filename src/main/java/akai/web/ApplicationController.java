package akai.web;

import akai.jpa.User;
import akai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ApplicationController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/user/{userName}")
    public String home(@PathVariable("userName") String userName, Map<String, Object> model) {
        final User user = userService.findUserByName(userName);
        if (user != null) {
            model.put("user", user.toString());
            model.put("address", user.getAddress().toString());
            return "userDetails";
        }

        model.put("userName", userName);
        return "userNotFound";
    }

    @RequestMapping("/user/delete/{userId}")
    public String home(@PathVariable("userId") long userId) {
        userService.deleteUserById(userId);
        return "userDeleted";
    }
}
