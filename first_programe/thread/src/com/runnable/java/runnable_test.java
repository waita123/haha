package com.runnable.java;

public class runnable_test {
    /*实现runnable接口
    1.创建类实现接口runnable
    2.重写runnnable类中的run()方法
    3.创建类对象
    4.用Thread中的带参方法调用start();
     */
    public static void main(String[] args)
    {
        myThread it =new myThread();
       new Thread(it).start();//Thread(it)可以写成Thread ia
        // = new Thread(it);这里体现了多态 ia.start();
        //这里的start()方法是myThread重写的方法，作用：1.启动当前线程
        // 2.调用当前线程的runnable 因为Thread(runnable target)有形参
        // 调用的是target.run();target=it;
        //再次启动需要创建新的Thread对象
    }
}
class myThread implements Runnable{

    @Override
    public void run() {
        System.out.println("ncd");
    }
}
