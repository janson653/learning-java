package com.janson653.basicexecise.beanvalidator;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanWrapperTest {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getName());
        BeanWrapper beanWrapper = new BeanWrapperImpl(person);

        beanWrapper.setPropertyValue("name", "zhangqian");
        System.out.println(person.getName());

    }
}
