package com.study.param;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 参考网址说明 编写的测试类测试
 * https://github.com/hollischuang/toBeTopJavaer/blob/master/basics/java-basic/java-pass-by.md
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/4/11 16:48
 */
public class ParamTest<K,V> {

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

        Map<String,String> testMap = new HashMap<>(20);
        Object rs = testMap.put("test","test");
        System.out.println(" put的结果 : " + rs);
//        System.out.println(" 返回的结果 : " + testMap.get("test"));

//        ParamTest map = new ParamTest();
//        map.put("s","test");
//
//        /**
//         * JAVA中的值传递和引用传递
//         * Java中其实还是值传递的，只不过对于对象参数，值的内容是对象的引用
//         * **/
//        ParamTest test = new ParamTest();
//        test.setName("hello");
//        test.setGender("男");
//        System.out.println("输出的结果01 : " + test);
//        test.change(test);
//        System.out.println("输出的结果03 : " + test);
//        // 最终发现 :  test引用变量对应的对象的值 并没有被改变
//
//        int i = 200;
//        System.out.println(" 涉世未深,原本的样貌 : " + i);
//        changeBasicType(i);
//        System.out.println(" 历经沧桑,原本的模样 : " + i);
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


    /**
     * 提供key的特殊hashcode值
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    final void put(K key, V value){
        putVal(hash(key),key,value);
    }
    /**
     * 模拟put参数值
     * @param hash
     * @param key
     * @param value
     */
    final void putVal(int hash, K key, V value){
        Node<K,V>[] tab;
        Node<K, V> p;
        int i;
        tab = resize();
        int n = tab.length;
        System.out.println(" i = (n - 1) : " + (i = (n - 1)));
        System.out.println(" tab : " + tab[i = (n - 1)]);
        System.out.println(" 结果 : " + (p = tab[i = (n - 1) & hash]));
        System.out.println(" 计算 : " + (9&hash));
        System.out.println(" hash : " + (i = (n - 1) & hash));
        System.out.println((p = tab[i = (n - 1) & hash]) == null);
    }
    /**
     * 初始化默认大小的链表数组
     * @return
     */
    final Node<K,V>[] resize(){
        return (Node<K,V>[])new Node[10];
    }

    /**
     * 自定义链表对象
     * @param <K>
     * @param <V>
     */
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public final K getKey()        { return key; }
        @Override
        public final V getValue()      { return value; }
        @Override
        public final String toString() { return key + "=" + value; }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }

}
