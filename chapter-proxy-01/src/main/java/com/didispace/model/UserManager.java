package com.didispace.model;

/**
 * @author LuHongGang
 * @date 2018-05-22 14:31
 * @since 1.0
 **/
public interface UserManager {
    public  void addUser(String userName,String passWord);
    public  void queryUser(String id);
}
