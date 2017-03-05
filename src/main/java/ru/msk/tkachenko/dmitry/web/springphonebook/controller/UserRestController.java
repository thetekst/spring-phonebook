package ru.msk.tkachenko.dmitry.web.springphonebook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import ru.msk.tkachenko.dmitry.web.springphonebook.data.UserDao;
import ru.msk.tkachenko.dmitry.web.springphonebook.error.UserNotFoundException;
import ru.msk.tkachenko.dmitry.web.springphonebook.model.User;
import ru.msk.tkachenko.dmitry.web.springphonebook.error.Error;

import java.util.List;
import javax.validation.Valid;

@RestController
public class UserRestController {
    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public User getUserById(@PathVariable Long id) {
        return userDao.find(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public Long save(@Valid User user, Errors errors) {
        logger.info(user.getPhone());
        logger.info(user.getUsername());

        if (errors.hasErrors()) {
            logger.info("error");
            return null;
        }

        Long id = userDao.save(user);

        logger.info(String.valueOf(id));

        return id;
    }

    @RequestMapping(value = "/user/remove/{id}", method = RequestMethod.POST, produces = "application/json")
    public void deleteUserById(@PathVariable Long id) {
        userDao.delete(id);
    }

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.POST, produces = "application/json")
    public int updateUserById(
            @PathVariable Long id,
            @RequestParam("username") String username,
            @RequestParam("phone") String phone) {
        System.out.printf("******%d %s %s\n", id, username, phone);
//        return 1;
        return userDao.update(new User(id, username, phone));
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> users() {
        return userDao.findAll();
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public
    @ResponseBody
    Error userNotFound(UserNotFoundException e) {
        long userId = e.getUserId();
        return new Error(4, "User [" + userId + "] not found");
    }
}
