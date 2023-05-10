package com.thread.java;
public class thread_test {
    /*1.创建一个继承于thread类的方法
    2.重写thread类的run（）--->将此线程执行的操作生命在run方法中
    3.创建一个thread的对象
    4.通过此对象调用start()
    5.currentThread();是thread中的静态方法,返回当前线程可以调用getName();

     */
    public static void main(String[] args)
    {
        mythread it = new mythread();
        it.start();//1.可以自动启动当前线程2.带哦用当前线程的run()
        // 3.对于一个线程类将不能多次调用，只能启动了一次，如果还需要启动则需要新建一个对象

    }
}
class mythread extends Thread
{
    @Override
    public void run() {
        for(int i=0;i<100;i++)
        {
            if(i%2==0)
            {
                System.out.println(i);
            }
        }
    }
}






