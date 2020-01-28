package com.cauchy.ds;

import sun.dc.pr.PRError;

import java.util.Scanner;

/**
 * @author duangduangda
 * @description 使用数组模拟循环队列
 */
public class CircleArrayQueue {
	public static void main(String[] args) {
		// 队列有效数据最大为2，因为设定了空出一个空间做约定
		MyQueue queue = new MyQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据至队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查询队列头部的数据");
			key = scanner.next().charAt(0);
			switch (key) {
				case 's':
					queue.showAll();
					break;
				case 'e':
					scanner.close();
					loop = false;
					break;
				case 'a':
					System.out.println("输入一个数值");
					int value = scanner.nextInt();
					queue.add(value);
					break;
				case 'g':
					int res = queue.pop();
					System.out.printf("取出的数据为：%d\n", res);
					break;
				case 'h':
					int head = queue.head();
					System.out.println("队列头数据为：" + head);
					break;
				default:
					break;
			}

		}
	}

	private static class MyQueue {
		private int maxSize;
		private int front;
		private int rear;
		private int[] data;

		public MyQueue(int maxSize) {
			this.maxSize = maxSize;
			this.data = new int[this.maxSize];
		}

		private boolean isFull() {
			return (this.rear + 1) % maxSize == this.front;
		}

		private boolean isEmpty() {
			return this.rear == this.front;
		}

		private void add(int element) {
			if (isFull()) {
				System.out.println("队列已满");
				return;
			}
			this.data[this.rear] = element;
			this.rear =  (this.rear + 1) % maxSize;
		}

		public void showAll() {
			if (isEmpty()) {
				System.out.println("当前队列无元素");
				return;
			}
			for (int i = front; i < front + size(); i++) {
				System.out.printf("data[%d]=%d\n", i % this.maxSize, data[i % this.maxSize]);
			}
		}

		public int size() {
			return (this.rear + this.maxSize - this.front) % this.maxSize;
		}

		private int pop(){
			if (isEmpty()) {
				throw new RuntimeException("队列为空");
			}
			int value = this.data[front];
			front = (front + 1) % maxSize;
			return value;
		}

		// 获取头部数据
		public int head(){
			if (isEmpty())	{
				throw new RuntimeException("队列为空");
			}
			return data[front+1];
		}


	}
}
