package bitmanipulation;

public class BitManipulation {
	public static void main(String[] args) {
		System.out.println(BitManipulator.getBit(10, 1)); // 1
		System.out.println(BitManipulator.setBit(10, 5)); // 45
		System.out.println(BitManipulator.clearBit(8, 3)); // 0
		System.out.println(BitManipulator.updateBit(7, 1, false)); // 5
	}
}
