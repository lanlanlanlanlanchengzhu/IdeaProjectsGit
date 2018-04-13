package business.impl;

import business.IUserService;

public class UserService implements IUserService{
    public String getName(int id) {
        System.out.println("getName method");
        return "x";
    }

    public String getAge(int id) {
        System.out.println("getAge method");
        return "18";
    }
}
