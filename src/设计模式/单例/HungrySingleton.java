package 设计模式.单例;

/**
 * @ClassName HungrySingleton
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/24 下午8:35
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return instance;
    }
}
