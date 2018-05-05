package janson.myspring.anatation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class MyAnatationParser implements MyBeanFactory {
    private Map<String, Object> objectMap = new HashMap<>();

    public MyAnatationParser() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // todo my anotation begin to parser
        File file = new File("/home/janson/workspace/learning-java/myspring/src/main/java/janson/myspring/anatation");
        if (file.exists() && file.isDirectory()) { // 读取当前目录下所有问题
            File[] subFiles = file.listFiles();
            for (int i = 0, len = subFiles.length; i < len; i++) {
                File tmp = subFiles[i];
                //
                System.out.println(tmp);
                if (tmp.getName().endsWith(".java")) {
                    Class cls = Class.forName(getClass().getPackage().getName() + "."
                            + tmp.getName().replace(".java", ""));
                    if (cls.isAnnotationPresent(MyComponent.class)) { // 找到当前ｐａｃｋａｇｅ下加了自定义注解的类注解
                       MyComponent component = (MyComponent) cls.getAnnotation(MyComponent.class);
                       System.out.println(component.value());
                       objectMap.put(component.value(), cls.newInstance());
                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(MyAnatationParser.class.getPackage().getName());
    }

    @Override
    public Object getBean(String beanName) {
        return objectMap.get(beanName);
    }
}
