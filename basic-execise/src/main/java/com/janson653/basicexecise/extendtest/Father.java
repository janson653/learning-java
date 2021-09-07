package com.janson653.basicexecise.extendtest;

/**
 * @author zhangqian
 * @date 2021/8/31
 */
public class Father {
    public String name = "zhangsan";
    public Integer age = 55;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
