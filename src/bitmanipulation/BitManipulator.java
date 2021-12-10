package bitmanipulation;

public class BitManipulator {
	public static String getBinaryString(int num) {
		return String.format("%8s", Integer.toBinaryString(num));
	}
	
	/**
	 * Returns the value of the bit of an integer
	 * at specified an index.
	 * @param num number
	 * @param index index
	 * @return <code>1</code> or <code>0</code>
	 */
	public static int getBit(int num, int index) {
		return (num & (1 << index)) == 0 ? 0 : 1;
	}
	
	/**
	 * Sets the bit of an integer to <code>1</code>.
	 * @param num number
	 * @param index index
	 * @return the updated number
	 */
	public static int setBit(int num, int index) {
		return num | (1 << index);
	}
	
	/**
	 * Sets the bit of an integer to <code>0</code>.
	 * @param num number
	 * @param index index
	 * @return the updated integer
	 */
	public static int clearBit(int num, int index) {
		return num & ~(1 << index);
	}
	
	/**
	 * Update the bit of an integer to a value.
	 * @param num number
	 * @param index index
	 * @return the updated integer
	 */
	public static int updateBit(int num, int index, boolean isOne) {
		int cleared = num & ~(1 << index); // Clear the bit at index
		int val = isOne ? 1 : 0;
		return cleared | (val << index);
	}
}
