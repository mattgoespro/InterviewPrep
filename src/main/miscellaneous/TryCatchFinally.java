package miscellaneous;

public class TryCatchFinally {
	public static void main(String[] args) {
		System.out.println(TryCatchFinally.finallyWithReturnInCatch());
	}
	
	/**
	 * Finally block is always executed.
	 * This method always returns 0 regardless
	 * of the return inside the try and catch blocks.
	 */
	static int finallyWithReturnInCatch() {
		try {
			System.out.println("Throwing exception.");
			"".substring(-1); // throws StringIndexOutOfBoundsException
			return 1;
		} catch (Exception e) {
			System.out.println("Caught exception. Returning.");
			return -1;
		} finally {
			System.out.println("Cleaning up in finally.");
			return 0;
		}
	}
}
