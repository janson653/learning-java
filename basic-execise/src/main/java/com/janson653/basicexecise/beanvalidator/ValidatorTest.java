package com.janson653.basicexecise.beanvalidator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class ValidatorTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("zhang");
        person.setAge(-1);
        DataBinder binder = new DataBinder(person);
        binder.setValidator(new PersonValidator());

        // bind to targett object

        // validate
        binder.validate();

        BindingResult result = binder.getBindingResult();

        System.out.println("hasError=" + result.hasErrors());
        System.out.println(result);
    }
}
