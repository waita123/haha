package com.secure.java;/*
@author keqi
@create 2023-05-08 19:23
*/

public class buy_ticket_test {
    /*1.类继承Thread
    2.重写run();方法
    3.创建子类对象
    4.调用类启动线程
*/
    public static void main(String[] args)
    {
        window it = new window();
        window iu = new window();
        window ia = new window();
        it.setName("窗口1：");
        iu.setName("窗口2：");
        ia.setName("窗口3：");
        it.start();
        iu.start();
        ia.start();
        //System.out.println(it.getName());
    }
}
class window extends Thread{
    private static int ticket=100;//共享数据必须声明为静态
    private static Object it = new Object();//锁要唯一但是主类中创建了三个对象所以有三个锁加static修饰变成一个锁
    //同步方法
    public void run(){
        while(ticket>0)
        {
            print();
        }
    }
    private static synchronized void print()//因为锁只能有一个，那么用static来修饰共享一个方法
    {
        System.out.println(Thread.currentThread().getName() + ":" + ticket);//获取当前线程的名称
                    ticket--;
    }
    //同步代码块
//    public void run()
//    {
//        while (true) {
//            synchronized(it){
//                if (ticket > 0) {
//                    System.out.println(Thread.currentThread().getName() + ":" + ticket);//获取当前线程的名称
//                    ticket--;
//                } else
//                    break;
//            }
//        }
}

