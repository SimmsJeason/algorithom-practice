package javaBase.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class pC = Class.forName("javaBase.reflect.People");
        People people = (People) pC.newInstance();
        System.out.println("Class is " + pC.getName());
        Method methodPrivate = pC.getDeclaredMethod("getHello", String.class);
        methodPrivate.setAccessible(true);
        Object str = methodPrivate.invoke(people, "Bod");
        System.out.println(str);
        Method methodPublic = pC.getMethod("sayHello", String.class);

        methodPublic.invoke(people, "Welcome");

        Field name = pC.getDeclaredField("name");
        name.setAccessible(true);//私有变量 或者方法，必须设置该项为true
        name.set(people, "Simms");
        methodPublic.invoke(people, "Welcome");
    }
}
