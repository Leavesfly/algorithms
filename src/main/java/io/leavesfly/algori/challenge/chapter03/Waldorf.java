package io.leavesfly.algori.challenge.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Waldorf {
	private final int height = 20;
	private int[][] numTable = new int[height][];

	public Waldorf() {
		for (int i = 0; i < height; i++) {
			int[] row = new int[height];
			for (int j = 0; j < height; j++) {
				row[j] = (int) (Math.random() * 10);
			}
			numTable[i] = row;
		}
	}

	public void printNumTable() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				System.out.println(numTable[i][j]);
			}
			System.out.println();
		}
	}

	public String inputData() {
		Scanner scanner = new Scanner(System.in);
		int temp = scanner.nextInt();
		String data=String.valueOf(temp);
		return data;
	}

	public List<Location> getLocationListByFirstNum(int[] data) {
		List<Location> locationList = new ArrayList<Location>();
		int num = data[0];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				if (numTable[i][j] == num) {
					locationList.add(new Location(i, j));
				}
			}
		}
		return locationList;
	}

	public List<String> matchData(String data, Location location) {
		List<String> strList=new ArrayList<String>();
		if (data.length() <= location.getX() + 1) {
			String str="";
			for(int i=location.getX();i>=0;i--){
				str += numTable[i][location.getY()];
			}
			if(str.equals(data)){
				strList.add(new String("0 �� ����"));
			}
			
		}
		if ((location.getX() + data.length() <= height)
				&& (location.getY() + data.length() <= height)) {
			String str="";
			for(int i=location.getX(), j=location.getY();i>=0&&j<=height-1;i--,j++){
				str +=numTable[i][j];
			}
			if(str.equals(data)){
				strList.add(new String("1.5 �� ����"));
			}

		}
		if (location.getY() + data.length() <= height) {
			String str="";
			for(int i=location.getY();i<=height-1;i++){
				str += numTable[location.getX()][i];
			}
			if(str.equals(data)){
				strList.add(new String("3 �� ����"));
			}
		}
		if (location.getX() + data.length() <= height) {
			
		}
		if ((location.getX() + data.length() <= height)
				&& (location.getY() - data.length() + 1 >= 0)) {

		}
		if (location.getY() - data.length() + 1 >= 0) {

		}
		if ((location.getY() - data.length()+1 >=0)
				&& (location.getX() - data.length() + 1 >= 0)) {
			
		}

		return strList;
	}

	public static void main(String[] args) {

	}

}

class Location {
	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
