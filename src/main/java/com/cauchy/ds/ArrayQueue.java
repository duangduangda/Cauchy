package com.cauchy.ds;

import java.util.Scanner;

/**
 * @author duangduangda
 * 使用数组模拟队列,存在的问题是，当取出元素再重新添加元素时，会出现"队列已满，无法添加新元素的问题"
 */
public class ArrayQueue {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop){
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据至队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查询队列头部的数据");
			key = scanner.next().charAt(0);
			switch (key){
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
					System.out.printf("取出的数据为：%d\n",res);
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

	private static class MyQueue{
		// 队列最大容量
		private int maxSize;
		// 队列头,指向队列前一个数据
		private int front;
		// 队列尾,包含队列最后一个元素
		private int rear;
		// 用于存数据，模拟队列
		private int[] data;

		public MyQueue(int maxSize){
			this.maxSize = maxSize;
			data = new int[this.maxSize];
			front = -1;
			rear = -1;
		}

		// 判断队列是否满
		public boolean isFull(){
			return this.rear == this.maxSize - 1;
		}

		// 判断队列是否为空
		public boolean isEmpty(){
			return this.front == this.rear;
		}

		// 添加元素入列
		public void add(int element){
			if (isFull()){
				System.out.println("队列已满，无法添加新元素");
				return;
			}
			this.data[++rear] = element;
		}

		// 获取队列队列的数据，出队列
		public int pop(){
			if (isEmpty()){
				throw new RuntimeException("队列为空");
			}
			return data[++front];
		}

		// 获取队列的所有元素
		public void showAll(){
			if (isEmpty()){
				System.out.println("队列为空，没有数据");
				return;
			}
			for (int i = 0;i < this.data.length;i++){
				System.out.printf("data[%d]=%d\n",i,this.data[i]);
			}
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
