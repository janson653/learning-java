package com.janson653.basicexecise.extendtest;

/**
 * @author zhangqian
 * @date 2021/8/31
 */
public class Son extends Father {
    public String name = "zhangsan's son";
    public Integer age = 30;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
