package com.janson653.basicexecise.basic;

public class OuterClass {
    private String name ;  
    private int age;  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
      
    static class InnerClass {
        public InnerClass(){  
            //name = "chenssy";
            //age = 23;
        }  
    }

    public static void main(String[] args) {
    }
}  