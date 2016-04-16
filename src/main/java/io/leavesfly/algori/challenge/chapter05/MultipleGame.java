package io.leavesfly.algori.challenge.chapter05;

public class MultipleGame {
	public static String win(int n) {
		int temp = n / 9;
		int end = n % 9;
		int i = 0;
		while (Math.pow(2, i) <= temp) {
			i++;
		}
		if (end == 0 && Math.pow(2, i) == temp) {
			if (i % 2 == 0) {
				return "Ollie Win";
			} else {
				return "Stan Win";
			}
		} else {
			if (i % 2 == 0) {
				return "Stan Win";
			} else {
				return "Oliie Win";
			}	
		}

	}
	
	public static void main(String[] args){
		
		System.out.println(MultipleGame.win(162));
	}
	
}
