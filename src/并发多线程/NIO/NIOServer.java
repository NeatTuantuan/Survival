package 并发多线程.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName NIOServer
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/3/3 下午9:05
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class NIOServer {
    public static void main(String[] args)throws Exception{
        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //得到一个selector对象
        Selector selector = Selector.open();
        //绑定6666端口，在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设为非阻塞
        serverSocketChannel.configureBlocking(false);
        //将ServerSocketChannel注册带Selector上，设置关心事件为OP_ACCEPT
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        //循环等待客户端链接
        while(true){

            //等待1s，若没有事件则返回
            if (selector.select(1000) == 0){
                System.out.println("等待1s，客户端未连接");
                continue;
            }
            /**
             * 若返回>0，就获取相关的SelectionKey集合
             * 若返回>0，表示已经获取到关注的事件
             * selector.selectedKeys()返回事件关注的集合
             * 通过selectionKeys反向获取通道
             */
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //使用迭代器遍历selectionKeys集合
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()){
                //获取到SelectionKey
                SelectionKey key = iterator.next();
                //根据key对应的通道做相应的处理，如果是OP_ACCEPT，表示有新客户端链接
                if (key.isAcceptable()){
                    //为该客户端生成一个socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端链接："+socketChannel.hashCode());
                    //将socketChannel设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到Selector上，关注时间为OP_READ，同时给socketChannel关联一个ByteBuffer
                    socketChannel.register(selector,SelectionKey.OP_READ,ByteBuffer.allocate(1024));
                }

                if (key.isReadable()){
                    //通过key反向获取对应的channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("from 客户端："+new String(buffer.array()));
                }
            }

        }
    }
}
