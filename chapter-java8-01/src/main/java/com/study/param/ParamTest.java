package com.study.param;

/**
 * 参考网址说明 编写的测试类测试
 * https://github.com/hollischuang/toBeTopJavaer/blob/master/basics/java-basic/java-pass-by.md
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/4/11 16:48
 */
public class ParamTest {

    private String name;
    private String gender;

    private ParamTest() {
    }

    public ParamTest(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ParamTest { " +
                "  name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static void main(String[] args) {
        /**
         * JAVA中的值传递和引用传递
         * **/
        ParamTest test = new ParamTest();
        test.setName("hello");
        test.setGender("男");
        System.out.println("输出的结果01 : " + test);
        test.change(test);
        System.out.println("输出的结果03 : " + test);
        // 最终发现 :  test引用变量对应的对象的值 并没有被改变

        int i = 200;
        System.out.println(" 涉世未深,原本的样貌 : " + i);
        changeBasicType(i);
        System.out.println(" 历经沧桑,原本的模样 : " + i);
    }

    /**
     * 查看是否改变原始对象的 值
     * @param user
     */
    private void change(ParamTest user){
        user = new ParamTest();
        user.setName("no-hello");
        user.setGender("女");
        System.out.println("输出的结果02 : " + user);
    }

    private static  void changeBasicType(int i){
        i = 100;
        System.out.println(" 正在经历着现实社会骨感的刺激,样貌开始变化 : " + i);
    }
}
