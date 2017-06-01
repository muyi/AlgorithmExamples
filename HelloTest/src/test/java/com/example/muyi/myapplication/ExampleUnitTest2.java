package com.example.muyi.myapplication;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by T530 on 2017/2/28.
 */

public class ExampleUnitTest2 {

    @Test
    public void testList() {
        List<Persion> list = new ArrayList<Persion>();
        Persion p = null;
        for (int i = 0; i < 10; i++) {
            p = new Persion("name" + i, i);
            list.add(p);
            p = null;
        }
        System.out.print(list.size() + "size\n");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).toString());
        }

    }


    @Test
    public void testList3() {
        Set<Persion> set = new HashSet<Persion>();
        Persion p1 = new Persion("唐僧", 25);
        Persion p2 = new Persion("孙悟空", 26);
        Persion p3 = new Persion("猪八戒", 27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:" + set.size() + " 个元素!"); //结果：总共有:3 个元素!
        p3.setAge(11); //修改p3的年龄,此时p3元素对应的hashcode值发生改变
        set.remove(p3); //此时remove不掉，造成内存泄漏

        set.add(p3); //重新添加，居然添加成功
        System.out.println("总共有:" + set.size() + " 个元素!"); //结果：总共有:4 个元素!

        for (Persion Persion : set) {
            System.out.println(Persion);
        }
    }

    @Test
    public void testArrayList() {
        List<String> list2 = Collections.synchronizedList(new ArrayList<String>());
        list2.hashCode();

        Map<String, String> map = new ConcurrentHashMap();


    }


    enum Color {
        RED, GREEN, BLANK, YELLOW
    }

    class Persion implements Serializable {


        int age;
        String name;
        transient int height;

        public Persion() {

        }


        public Persion(String name, int age) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Persion{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Persion persion = (Persion) o;

            if (age != persion.age) return false;
            return name != null ? name.equals(persion.name) : persion.name == null;

        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}
