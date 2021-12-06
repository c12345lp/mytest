package tools;

/* 懒汉模式 */
public class SingletonB {
    private  static  SingletonB s = null;
    public static SingletonB getInstance(){
        if(s == null){
            s = new SingletonB();
        }
        return s;
    }

}
