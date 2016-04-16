package io.leavesfly.algori.challenge.chapter05;

import java.util.Scanner;

public class BigInt {
	private static final int MAXDIGITS = 100;
	private static final int positive = 1;
	private static final int negative = -1;

	private byte[] digists;
	private int signBit;
	private int lastDigit;

	public BigInt() {
		digists = new byte[MAXDIGITS];
		signBit = positive;
		lastDigit = 0;
	}

	public byte[] getDigists() {
		return digists;
	}

	public void setDigists(byte[] digists) {
		this.digists = digists;
	}

	public int getSignBit() {
		return signBit;
	}

	public void setSignBit(int signBit) {
		this.signBit = signBit;
	}

	public int getLastDigit() {
		return lastDigit;
	}

	public void setLastDigit(int lastDigit) {
		this.lastDigit = lastDigit;
	}

	private byte charToByte(char charKey) {
		switch (charKey) {
		case '0':
			return (byte) 0;

		case '1':
			return (byte) 1;

		case '2':
			return (byte) 2;

		case '3':
			return (byte) 3;

		case '4':
			return (byte) 4;

		case '5':
			return (byte) 5;

		case '6':
			return (byte) 6;

		case '7':
			return (byte) 7;

		case '8':
			return (byte) 8;

		case '9':
			return (byte) 9;

		}
		return (byte) 0;
	}

	// ���õ�λ���Ҵ洢��λ
	public BigInt(String num) {
		if (num.startsWith("-")) {
			signBit = negative;
			digists = new byte[MAXDIGITS];
			lastDigit = num.length() - 2;
			int point = 0;
			for (int i = lastDigit; i >= 0; i--) {
				digists[i] = charToByte(num.charAt(++point));
			}
		} else {
			int point = 0;
			signBit = positive;
			digists = new byte[MAXDIGITS];
			lastDigit = num.length() - 1;
			for (int i = lastDigit; i >= 0; i--) {
				digists[i] = charToByte(num.charAt(point++));
			}
		}
	}

	public void printBigInt() {
		if (signBit == -1) {
			System.out.print("-");
			for (int i = lastDigit; i >= 0; i--) {
				System.out.print(digists[i]);
			}
		} else {
			for (int i = lastDigit; i >= 0; i--) {
				System.out.print(digists[i]);
			}
		}
		System.out.println();
	}

	private int max(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}

	private void zeroJustify() {
		while (lastDigit > 0 && digists[lastDigit] == 0) {
			lastDigit--;
		}
	}

	// �ӷ�
	public void addBigInt(BigInt addedBigInt,BigInt resultBigInt) {

		if (addedBigInt.getSignBit() == signBit) {
			resultBigInt.setSignBit(addedBigInt.getSignBit());
			byte carry = 0;
			resultBigInt.setLastDigit(max(lastDigit, addedBigInt.getLastDigit()) + 1);
			for (int i = 0; i <= resultBigInt.getLastDigit(); i++) {
				resultBigInt.getDigists()[i] = (byte) ((carry + digists[i] + addedBigInt
						.getDigists()[i]) % 10);
				carry = (byte) ((carry + digists[i] + addedBigInt.getDigists()[i]) / 10);
			}
			resultBigInt.zeroJustify();
		} else if (addedBigInt.getSignBit() == negative) {
			addedBigInt.setSignBit(positive);
			subtractBigInt(addedBigInt,resultBigInt);
			addedBigInt.setSignBit(negative);
		} else {
			signBit = positive;
			addedBigInt.subtractBigInt(this,resultBigInt);
			signBit = negative;
		}
		return ;
	}
	
	private int compareBigInt(BigInt subtractNum){
		if(signBit==negative&&subtractNum.getSignBit()==positive){
			return negative;
		}
		if(signBit==positive&&subtractNum.getSignBit()==negative){
			return positive;
		}
		if(subtractNum.getLastDigit()>lastDigit){
			return negative*signBit;
		}
		if(lastDigit>subtractNum.getLastDigit()){
			return positive*signBit;
		}
		
		for(int i=lastDigit;i>=0;i--){
			if(lastDigit>subtractNum.getLastDigit()){
				return positive*signBit;
			}
			if(subtractNum.getLastDigit()>lastDigit){
				return negative*signBit;
			}
				}
		return positive;
			
	}

	// ����
	public void subtractBigInt(BigInt subtractNum,BigInt resultBigInt) {
		if (signBit == negative || subtractNum.getSignBit() == negative) {
			subtractNum.setSignBit(negative * subtractNum.getSignBit());
			addBigInt(subtractNum, resultBigInt);
			subtractNum.setSignBit(negative * subtractNum.getSignBit());
			return ;
		}
		if(compareBigInt(subtractNum)==negative){
			subtractNum.subtractBigInt(this,resultBigInt);
			resultBigInt.setSignBit(negative);
			return ;
		}
		
		
		resultBigInt.setLastDigit(max(lastDigit, subtractNum.getLastDigit()));
		int borrow=0;
		int digit=0;
		for(int i=0;i<=resultBigInt.getLastDigit();i++){
			digit=digists[i]-borrow-subtractNum.getDigists()[i];
			if(digists[i]>0){
				borrow=0;
			}
			if(digit<0){
				digit +=10;
				borrow=1;
			}
			resultBigInt.getDigists()[i]=(byte)(digit%10);
		}
		resultBigInt.zeroJustify();
		
	}
	
	//��10Ϊ��λ����
	private void digitShift(int d){
		if(d==0){
			return ;
		}
		if(lastDigit==0&& digists[0]==0){
			return ;
		}
		for(int i=lastDigit;i>=0;i--){
			digists[i+d]=digists[i];
		}
		for(int i=0;i<d;i++){
			digists[i]=0;
		}
		lastDigit +=d;
	}
	
	private void cleanToZero(){
		lastDigit=0;
		signBit=positive;
		digists[lastDigit]=0;
		zeroJustify();
	}
	
	//�˷�
	public void multiplyBigInt(BigInt multiBigInt,BigInt resultBigInt){
		BigInt tempBigInt=new BigInt();
		BigInt zero=new BigInt();
		for(int i=0;i<=lastDigit;i++){
			for(int j=1;j<=digists[i];j++){
				if(j==1){
					addBigInt(zero, tempBigInt);
				}else{
					addBigInt(this, tempBigInt);
				}	
			}
			tempBigInt.digitShift(i);
			addBigInt(tempBigInt, resultBigInt);
			tempBigInt.cleanToZero();
		}
		resultBigInt.setSignBit(signBit*multiBigInt.getSignBit());
	}
	
	private void voluation(BigInt bigInt){
		signBit=bigInt.signBit;
		lastDigit=bigInt.lastDigit;
		for(int i=bigInt.lastDigit;i>=0;i--){
			digists[i]=bigInt.digists[i];
		}
				
	}
	
	public void divideBigInt(BigInt divideBigInt,BigInt resultBigInt){
		resultBigInt.setSignBit(signBit*divideBigInt.getSignBit());
		int aSign=signBit;
		int bSign=divideBigInt.getSignBit();
		
		
		signBit=positive;
		divideBigInt.setSignBit(positive);
		
		BigInt row=new BigInt();
		BigInt tmp=new BigInt();
		
		resultBigInt.setSignBit(signBit);
		for(int i=lastDigit;i>=0;i--){
			row.digitShift(1);
			row.digists[0]=digists[i];
			resultBigInt.digists[i]=0;
			while(row.compareBigInt(divideBigInt)==positive){
				resultBigInt.digists[i]++;
				row.subtractBigInt(divideBigInt, resultBigInt);
				row.voluation(tmp);
			}
		}
		
		resultBigInt.zeroJustify();
		signBit=aSign;
		divideBigInt.signBit=bSign;
	}
	
	
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigInt bigInt = new BigInt(scanner.next());
		bigInt.printBigInt();
		BigInt result=new BigInt();
		bigInt.addBigInt(bigInt, result);
		result.printBigInt();
	}
}
