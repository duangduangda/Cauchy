package com.cauchy.ds;

public class SparseArray {
	public static void main(String[] args) {
		// 创建二维数组，0表示没有棋子，1为黑子，2为蓝子
		int[][]chesses = new int[11][11];
		chesses[1][2] = 1;
		chesses[2][3] = 2;
		// 输出原始的二维数组
		System.out.println("原始的二维数组：");
		for (int[] row:chesses){
			for(int data:row){
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		// 将二维数组转为稀疏数组
		int sum = 0;
		for (int i = 0;i < 11;i++){
			for (int j = 0;j < 11;j++){
				if (chesses[i][j] != 0){
					sum++;
				}
			}
		}
		System.out.println("sum = " + sum);

		// 创建对应的稀疏数组
		int[][]sparses = new int[sum+1][3];
		sparses[0][0] = 11;
		sparses[0][1] = 11;
		sparses[0][2] = sum;

		// 用于记录第一个非0的
		int count = 0;
		for (int i = 0; i < 11;i++){
			for(int j = 0;j < 11;j++){
				if (chesses[i][j] != 0){
					count++;
					sparses[count][0] = i;
					sparses[count][1] = j;
					sparses[count][2] = chesses[i][j];
				}
			}
		}
		System.out.println();
		System.out.println("稀疏数组：");
		for (int i = 0;i < sparses.length;i++){
			System.out.printf("%d\t%d\t%d\t\n", sparses[i][0],sparses[i][1],sparses[i][2]);
		}

		// 将稀疏数组恢复成二维数组
		//1. 读取稀疏数组的第一行，创建二维数组
		int[][] chessArray = new int[sparses[0][0]][sparses[0][1]];
		chessArray[sparses[1][0]][sparses[1][1]] = sparses[1][2];
		chessArray[sparses[2][0]][sparses[2][1]] = sparses[2][2];
		System.out.println("恢复后的二维数组：");
		for (int i = 0;i < sparses[0][0];i++){
			for (int j = 0;j < sparses[0][1];j++){
				System.out.printf("%d\t",chessArray[i][j]);
			}
			System.out.println();
		}

	}
}
