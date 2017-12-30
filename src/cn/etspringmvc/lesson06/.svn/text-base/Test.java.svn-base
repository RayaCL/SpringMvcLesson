package cn.etspringmvc.lesson06;

public class Test {
	/**
	 * 一个ajax线程是否执行完成 可以通过回调函数
	 * 异步 多个线程同时执行 无法判断 谁先执行
	 * 同步 一次只能一个线程执行
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		MyThread m=new MyThread();
		m.start();
//		m.join();
		System.out.println("main");
	}
	static class MyThread extends Thread{
		@Override
		public void run() {
			System.out.println("线程执行run方法");
		}
	}
}
