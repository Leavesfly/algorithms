package io.leavesfly.algori.challenge.chapter07;

public class Marble {
	public static String getBestSolution(int s, int c1, int n1, int c2, int n2) {
		int x1=0;
		int x2=0;
		int cost=0;
		int minCost=Integer.MAX_VALUE;
		String str="failed";
		for (int i = 1; i < s; i++) {
			if (i % n1 != 0 || (s - i) % n2 != 0) {
				continue;
			}else{
				x1=i/n1;
				x2=(s-i)/n2;
				cost=x1*c1+x2*c2;
				if(minCost>cost){
					minCost=cost;
					str=x1+","+x2+"  minCost:"+minCost;
				}
			}	
		}
		
		return str;
	}
	
	public static void main(String[] args){
		System.out.println(Marble.getBestSolution(40, 5, 9, 5, 12));
	}
	
}
