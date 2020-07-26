package JVM.自定义类加载器;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName Load
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/3/16 下午8:26
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class Load {
    public static void main(String[] args) throws Exception{
        String classPath = "/Users/tuantuan/Log.class";

        UserClassLoader myClassLoader = new UserClassLoader(classPath);
        String packageNamePath = "org.myorg.Log";

        //加载Log这个class文件
        Class<?> Log = myClassLoader.loadClass(packageNamePath);

        System.out.println("类加载器是:" + Log.getClassLoader());

        //利用反射获取main方法
//        Method method = Log.getDeclaredMethod("main", String[].class);
//        Object object = Log.newInstance();
//        String[] arg = {"4"};
//        method.invoke(object, (Object) arg);
        Method method = Log.getDeclaredMethod("test", String.class);
        Object object = Log.newInstance();
        String arg = "test";

        String result = (String) method.invoke(object, arg);
        System.out.println(result);


    }
}
