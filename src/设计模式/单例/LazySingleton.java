package 设计模式.单例;

/**
 * @ClassName LazySingleton
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/24 下午8:37
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
