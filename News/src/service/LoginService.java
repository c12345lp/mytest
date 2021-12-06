package service;

import enity.User;

public interface LoginService {
    public User validate(String username, String upwd);
}
