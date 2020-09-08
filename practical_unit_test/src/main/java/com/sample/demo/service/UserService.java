package com.sample.demo.service;

import java.util.Map;

public class UserService {

    private final UserDAO userDAO;
    private final SecurityService securityService;

    public UserService(UserDAO userDAO, SecurityService securityService) {
        this.userDAO = userDAO;
        this.securityService = securityService;
    }

    public void assignPassword(User user) {
        String passwordMd5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }
}

interface UserDAO {
    void updateUser(User user);
    User getUserByProperties(Map<String, String> props);
}

interface   SecurityService {
    String md5(String password);
}

class User {

    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
