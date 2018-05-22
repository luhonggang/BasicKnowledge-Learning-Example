package com.didispace.model;

/**
 * 当前对象为 要代理的对象
 * @author LuHongGang
 * @date 2018-05-22 14:32
 * @since 1.0
 **/
public class UserManagerImpl implements  UserManager {
    @Override
    public void addUser(String userName, String passWord) {
        System.out.println("++++++执行被代理对象的添加用户的方法++++++");

    }

    @Override
    public void queryUser(String id) {
        System.out.println("++++++执行被代理对象的查询用户的方法++++++");
    }
}
