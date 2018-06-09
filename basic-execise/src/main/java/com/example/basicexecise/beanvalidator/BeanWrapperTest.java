package com.example.basicexecise.beanvalidator;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.validation.Errors;
import org.springframework.web.bind.EscapedErrors;

public class BeanWrapperTest {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getName());
        BeanWrapper beanWrapper = new BeanWrapperImpl(person);

        beanWrapper.setPropertyValue("name", "zhangqian");
        System.out.println(person.getName());

    }
}
