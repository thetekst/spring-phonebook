package ru.msk.tkachenko.dmitry.web.springphonebook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.msk.tkachenko.dmitry.web.springphonebook.data.UserDao;
import ru.msk.tkachenko.dmitry.web.springphonebook.model.User;


@Controller
@RequestMapping({"/", "home"})
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public String userList(Model model) {

        model.addAttribute("user", new User()); // for modelAttribute="user" in userList.jsp form
        model.addAttribute("users", userDao.findAll());
        return "userList";
    }
}
