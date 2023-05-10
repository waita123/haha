package com.secure.java;/*
@author keqi
@create 2023-05-08 20:16
*/

public class buy_ticket_runnable_test {
    /*1.类接口Runnable
    2.重写run();方法
    3.创建类实现接口
    4.调用类启动线程
*/
    public static void main(String[] args)
    {
        window1 it = new window1();//因为只创建了一个对象，用三个构造器调用所以可以实现数据共享
        Thread ii = new Thread(it);
        Thread iu = new Thread(it);
        Thread ia = new Thread(it);
        ii.setName("窗口1");
        iu.setName("窗口2");
        ia.setName("窗口3");
        ii.start();
        iu.start();
        ia.start();
    }
}
class window1 implements Runnable{
    private int ticket=100;//接口数据本身具有共享性不需要声明为静态属性
    Object it =new Object();
    public void run()//因为如果像上面那样直接在方法前面加synchronized那么while循环也会包进去即所有任务执行就只会进行一个线程
    {
        while(ticket>0)
            print();
    }
    //同步方法
    private synchronized void print()
    {
        System.out.println(Thread.currentThread().getName() + ":" + ticket);//获取当前线程的名称
        ticket--;
    }

//    public void run() {
//        while(ticket>0)
//        {
//            synchronized(it)//任何一个监视器都就可以外创建或者内创建都可以
//            {
//                //加sleep:使线程阻塞
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println(Thread.currentThread().getName()+":"+ticket);//在Runnable中可以用Thread获取当前线程
//                ticket--;
//            }
//
//        }
//    }
}
