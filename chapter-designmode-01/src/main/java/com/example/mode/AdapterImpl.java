package com.example.mode;

/**
 * 对Adaptee的接口与Target接口进行适配
 * @author LuHongGang
 * @date 2018-05-24 14:03
 * @since 1.0
 * 关联关系 : 实线 + 箭头 表示 箭头指向被使用的类
 * 表示让一个类知道另一个类的属性和方法
 **/
public class AdapterImpl implements Target{

    private Adaptee adaptee;

    public AdapterImpl(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void someInfoMsg() {
        adaptee.someInfoMsg();
    }

    @Override
    public void otherInfoMsg() {
        System.out.println("+++++ 需要获取的其他的信息 ++++++");
    }

    public static void main(String[] args) {
        Target target = new AdapterImpl(new Adaptee());
        target.someInfoMsg();
        target.otherInfoMsg();
        /**
         *  理解 : 一个接口Target就可以获取到另一个类(Adaptee)的信息
         */
    }
}
