package ru.msk.tkachenko.dmitry.web.springphonebook.data;

import ru.msk.tkachenko.dmitry.web.springphonebook.model.User;

import java.util.List;


public interface UserDao {

    long totalCount();

    User save(User user);

    int update(User user);

    void delete(Long id);

    User find(Long id);

    List<User> findAll();


}
