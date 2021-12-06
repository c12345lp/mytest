package test;

import java.lang.reflect.Method;

public class TestReinfection {


    public static void main(String[] args) {
//        Foo foo = new Foo();
//        foo.Hello();
        try{
            Object foo2 = test.Foo.class.newInstance();
            Object foo = Class.forName("test.Foo").newInstance();
            Method m = foo.getClass().getDeclaredMethod("Hello",new Class<?>[0]);
            m.invoke(foo);
        }catch(Exception e) {
            System.out.println("失败");
            e.printStackTrace();
        }
    }

}
