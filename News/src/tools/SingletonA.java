package tools;

/* 饿汉 */
public class SingletonA {
    private  static  SingletonA s = new SingletonA();
    public static SingletonA getInstance(){
        return s;
    }
    public  SingletonA(){

    }
}
