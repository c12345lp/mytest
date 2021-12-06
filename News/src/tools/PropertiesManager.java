package tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//获取属性文件
public class PropertiesManager {
    private static PropertiesManager propertiesManager;
    //properties.load(InputStream);读取
    private static Properties properties;

    private PropertiesManager(){//构造方法
        String configFile = "Database.properties";//属性文件路径
        properties = new Properties();//创建properties对象
        //反射的应用，获取从属性文件的输入流in
        InputStream in = PropertiesManager.class.getClassLoader().getResourceAsStream(configFile);
        try{
            properties.load(in);//读取in的数据到properties中
            in.close();//关闭输入流
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //单例模式
    public static PropertiesManager getInstance(){
        if (propertiesManager==null){
            propertiesManager=new PropertiesManager();
        }
        return propertiesManager;
    }

    //通过参数名（参数key），获取参数值（方法的返回值）
    public String getString(String key) {
        return properties.getProperty(key);
    }
}
