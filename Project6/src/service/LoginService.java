package service;

import userdao.UserDao;
import entity.User;

import java.util.ArrayList;

public class LoginService {
    public boolean checkUser(String username, String password) {
        UserDao dao = new UserDao();
        User user = dao.findUserByName(username);
        System.out.println(user);
        return user != null && password.equals(user.getPassword()) ?true :false;
    }

    public ArrayList<String> getinfo(String username) {
        UserDao dao = new UserDao();
        ArrayList<String> info = new ArrayList<>();
        info = dao.getuserinfo(username);
        System.out.println("info success");
        return info;

    }
}
