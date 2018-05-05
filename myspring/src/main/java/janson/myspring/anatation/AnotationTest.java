package janson.myspring.anatation;

public class AnotationTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyAnatationParser parser = new MyAnatationParser();
        // 当底下的功能能够自动实现，就理解了Anotation, reflect
        People people = (People) parser.getBean("people");
        //People people = new People();
        people.doSomething();
    }
}
