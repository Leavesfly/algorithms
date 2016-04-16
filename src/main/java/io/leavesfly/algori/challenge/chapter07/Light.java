package io.leavesfly.algori.challenge.chapter07;

public class Light {
	public static boolean isLight(int n){
		int count=0;
		for(int i=1;i<=n;i++){
			if(n%i==0){
				count++;
			}
		}
		if(count%2==0){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(Light.isLight(8191));
	}
}
