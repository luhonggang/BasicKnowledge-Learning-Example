package com.didispace;

import com.didispace.aspect.CGLibProxy;
import com.didispace.aspect.JDKProxy;
import com.didispace.model.UserManager;
import com.didispace.model.UserManagerImpl;

import java.util.Objects;

/**
 * @author LuHongGang
 * @date 2018-05-22 14:41
 * @since 1.0
 **/
public class Client {
    public static void main(String[] args) {
        UserManager userManager = (UserManager) new CGLibProxy()
               .createProxyObject(new UserManagerImpl());
        System.out.println("-----------CGLibProxy-------------");
        userManager.addUser("tom", "root");

        System.out.println("-------------------------------------------------");
        System.out.println("-----------JDKProxy---------------");
        JDKProxy jdkPrpxy = new JDKProxy();
        UserManager userManagerJDK = (UserManager) jdkPrpxy
                .newProxy(new UserManagerImpl());
        userManagerJDK.addUser("tom", "root");

//        Object obj = null;
//        // 检查是否为空
//        Objects.requireNonNull(obj);
    }
}
