package io.leavesfly.algori.challenge.chapter01;

import java.util.Scanner;

public class Interpreter {
	public static final int RegisterNum = 10;
	public static final int RAM_UnitNUm = 1000;
	public int orderPoint;
	private int[] registers;
	private int[] ramUnit;
	private int orderNum;

	public Interpreter() {
		orderNum = 0;
		orderPoint = 0;
		registers = new int[RegisterNum];
		ramUnit = new int[RAM_UnitNUm];
	}

	public int getOrderPoint() {
		return orderPoint;
	}

	public void inputNum() {
		Scanner scanner = new Scanner(System.in);
		int inputData = 0;
		int mark = 0;
		System.out.println("��������ֵ:");
		while (!((inputData = scanner.nextInt()) == 0)) {
			if (inputData < RAM_UnitNUm) {
				ramUnit[mark] = inputData;
				mark++;
				orderNum = mark;
			} else {
				System.out.println("��������999����ֵ��");
				System.exit(0);
			}
		}
	}

	private int getUnitNum(int inputData) {
		int outputData = 0;
		if (inputData < 0) {
			System.out.println("�и�������˳���");
			System.exit(0);
		} else {
			outputData = inputData % 10;
		}
		return outputData;
	}

	private int getTenNum(int inputData) {
		int outputData = 0;
		if (inputData < 0) {
			System.out.println("�и�������˳���");
			System.exit(0);
		} else {
			outputData = inputData % 100;
			outputData = outputData / 10;
		}
		return outputData;
	}

	private int getHundredNum(int inputData) {
		int outputData = 0;
		if (inputData < 0) {
			System.out.println("�и�������˳���");
			System.exit(0);
		} else {
			outputData = inputData / 100;
		}
		return outputData;
	}

	private int getKind(int kind) {
		if (kind == 1) {
			return 0;
		} else if (kind == 2 || kind == 3 || kind == 4) {
			return 1;
		} else if (kind == 5 || kind == 6 || kind == 7) {
			return 2;
		} else if (kind == 8 || kind == 9 || kind == 0) {
			return 3;
		} else {
			System.out.println("getKind���?�˳�");
			System.exit(0);
		}
		return 0;
	}

	public void interpreteOrder(int inputOrder) {
		int kind = 0;
		kind = getHundredNum(inputOrder);
		kind = getKind(kind);
		switch (kind) {
		case 0:

			System.out.println("ִ�������Ĵ�����ݣ�");
			printRegisters();
			System.out.println("ִ���������ڴ���ݣ�");
			printRamUnit();
			System.out.println("ִ�йػ�ָ�����ǿ�ˣ�");
			System.exit(0);
			break;
		case 1:
			if (getHundredNum(inputOrder) == 2) {
				registers[getTenNum(inputOrder)] = getUnitNum(inputOrder);
				orderPoint++;
			}
			if (getHundredNum(inputOrder) == 3) {
				registers[getTenNum(inputOrder)] = (registers[getTenNum(inputOrder)] + getUnitNum(inputOrder)) % 1000;
				orderPoint++;
			}
			if (getHundredNum(inputOrder) == 4) {
				registers[getTenNum(inputOrder)] = (getUnitNum(inputOrder) * registers[getTenNum(inputOrder)]) % 1000;
				orderPoint++;
			}
			break;
		case 2:
			if (getHundredNum(inputOrder) == 5) {
				registers[getTenNum(inputOrder)] = registers[getUnitNum(inputOrder)];
				orderPoint++;
			}
			if (getHundredNum(inputOrder) == 6) {
				registers[getTenNum(inputOrder)] = (registers[getUnitNum(inputOrder)] + registers[getTenNum(inputOrder)]) % 1000;
				orderPoint++;
			}
			if (getHundredNum(inputOrder) == 7) {
				registers[getTenNum(inputOrder)] = (registers[getUnitNum(inputOrder)] * registers[getTenNum(inputOrder)]) % 1000;
				orderPoint++;
			}
			break;
		case 3:
			if (getHundredNum(inputOrder) == 8) {
				registers[getTenNum(inputOrder)] = ramUnit[registers[getUnitNum(inputOrder)]];
				orderPoint++;
			}
			if (getHundredNum(inputOrder) == 9) {
				ramUnit[registers[getUnitNum(inputOrder)]] = registers[getTenNum(inputOrder)];
				orderPoint++;
			}
			if (getHundredNum(inputOrder) == 0) {
				if (getUnitNum(inputOrder) != 0) {
					orderPoint = registers[getTenNum(inputOrder)];
					orderPoint++;
				}
			}

			break;
		}

	}

	public void printRegisters() {
		for (int i = 0; i < registers.length; i++) {
			System.out.print(registers[i]);
			System.out.print(", ");
		}
		System.out.println();
	}

	public void printRamUnit() {
		for (int i = 0; i < orderNum; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(ramUnit[i]);
			System.out.print(", ");

		}
		System.out.println();
	}

	// ִ������
	public void executeOrders() {
		while (true) {
			interpreteOrder(ramUnit[getOrderPoint()]);
		}

	}

	public static void main(String[] args) {
		Interpreter interpreter = new Interpreter();
		interpreter.inputNum();
		interpreter.printRegisters();
		interpreter.printRamUnit();
		interpreter.executeOrders();

	}

}
