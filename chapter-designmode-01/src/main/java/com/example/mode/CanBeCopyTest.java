package com.example.mode;

import org.springframework.beans.BeanUtils;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/8/6 13:59
 */
public class CanBeCopyTest {
    public static void main(String[] args) {

        // 被拷贝的对象的数据构造
        CanBeCopy canBeCopy = new CanBeCopy();
        canBeCopy.setCanId("1");
        canBeCopy.setName("我是被拷贝的对象");

        // 将 canBeCopy 引用指向的对象拷贝 到targetCopy引用 指向的对象
        TargetCopy targetCopy = new TargetCopy();
        BeanUtils.copyProperties(canBeCopy,targetCopy);
        System.out.println("拷贝的值 : " + targetCopy.getName());
    }
}
