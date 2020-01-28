package com.cauchy.ds;

import java.util.StringJoiner;

/**
 * @author duangduangda
 * @description 单链表
 */
public class SingleLinkedList {
	public static void main(String[] args) {
		Hero hero1 = new Hero(1, "宋江", "及时雨");
		Hero hero2 = new Hero(2, "卢俊义", "玉娇龙");
		Hero hero3 = new Hero(3, "吴用", "智多星");
		Hero hero4 = new Hero(4, "林冲", "豹子头");
		MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();
		mySingleLinkedList.add(hero1);
		mySingleLinkedList.add(hero2);
		mySingleLinkedList.add(hero3);
		mySingleLinkedList.add(hero4);

		mySingleLinkedList.list();
//		System.out.println();
//		mySingleLinkedList = new MySingleLinkedList();
//		mySingleLinkedList.addByOrder(hero1);
//		mySingleLinkedList.addByOrder(hero4);
//		mySingleLinkedList.addByOrder(hero3);
//		mySingleLinkedList.addByOrder(hero2);
//		mySingleLinkedList.list();

//		Hero toUpdateHero = new Hero(2, "卢俊义", "玉娇龙~~~~~");
//		mySingleLinkedList.updateByOrder(toUpdateHero);
//		mySingleLinkedList.list();
		mySingleLinkedList.delete(1);
		mySingleLinkedList.list();
		mySingleLinkedList.delete(4);
		mySingleLinkedList.list();
		mySingleLinkedList.delete(2);
		mySingleLinkedList.list();
		mySingleLinkedList.delete(3);
		mySingleLinkedList.list();



	}

	private static class MySingleLinkedList{
		// 定义头结点,头结点不存放具体的数据
		private Hero head = new Hero(0,"","");

		//尾插法，添加节点,不考虑排序问题
		private void add(Hero hero){
			Hero temp = this.head;
			// 找到要添加新元素的位置
			while (true){
				// 找到链表的尾部
				if (temp.next == null){
					break;
				}
				temp = temp.next;
			}
			// 将新节点添加搭配链表尾部
			temp.next = hero;
		}

		// 添加时保证排序
		private void addByOrder(Hero hero){
			// temp节点位于要添加位置的前一个节点，否则插入失败
			Hero temp = this.head;
			// 标识添加的编号是否存在，默认为False
			boolean flag = false;
			while (true){
				if (temp.next == null){// 位于节点尾部
					break;
				}
				if (temp.next.no > hero.no){
					break;
				}else if (temp.next.no == hero.no){
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if (flag){
				System.out.printf("英雄编号%d已存在，不能加入\n",hero.no);
			}else {
				hero.next = temp.next;
				temp.next = hero;
			}
		}

		private void updateByOrder(Hero hero){
			if (head.next == null){
				System.out.println("链表为空");
				return;
			}
			Hero temp = this.head.next;
			boolean flag = false;
			while (true){
				if (temp == null){//已经遍历完链表
					break;
				}
				// 找到节点
				if (temp.no == hero.no){
					flag = true;
					break;
				}
				// 继续寻找节点
				temp = temp.next;
			}
			if (!flag){
				System.out.println("未找到对应的节点");
				return;
			}else {
				temp.nickname = hero.nickname;
				temp.name = hero.name;
			}
		}

		private void delete(int no){
			Hero temp = this.head;
			boolean flag = false;
			while (true){
				if (temp.next == null){
					break;
				}
				if (temp.next.no  == no){
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if (flag){
				temp.next = temp.next.next;
			}else {
				System.out.println("未找到要删除的节点");
			}
		}
		// 遍历
		private void  list(){
			if (head.next == null){
				System.out.println("链表为空");
				return;
			}
			Hero temp = this.head.next;
			while (true){
				// 判断是否为链表最后
				if (temp == null){
					break;
				}
				System.out.println(temp);
				temp = temp.next;
			}
		}

	}

	private static class Hero{
		private int no;
		private String name;
		private String nickname;
		private Hero next;

		public Hero(int no,String name,String nickname){
			this.no = no;
			this.name = name;
			this.nickname = nickname;
		}

		@Override
		public String toString() {
			return new StringJoiner(", ", Hero.class.getSimpleName() + "[", "]")
					.add("no=" + no)
					.add("name='" + name + "'")
					.add("nickname='" + nickname + "'")
					.toString();
		}
	}
}
