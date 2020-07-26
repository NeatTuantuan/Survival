package 并发多线程.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @ClassName NIOClient
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/3/3 下午9:05
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class NIOClient {
    public static void main(String[] args) throws Exception{
        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置为非阻塞
        socketChannel.configureBlocking(false);
        //提供服务器IP与端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        //连接服务器
        if(!socketChannel.connect(inetSocketAddress)){
            while(!socketChannel.finishConnect()){
                System.out.println("因为链接需要时间，客户端不会阻塞，可以去做其他事");
            }
        }
        //若连接成功，则发送数据
        String str = "hello, world";
        //创建ByteBuffer缓冲区
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        //发送数据，将buffer数据写入channel
        socketChannel.write(buffer);
    }
}
