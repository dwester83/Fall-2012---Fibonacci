public class RecursiveFib {

	public RecursiveFib() {
		super();
	}

	private static int fibRecur(int n) {
		if (n <= 1)
			return 1;
		else
			return fibRecur(n - 1) + fibRecur(n - 2);
	}

	public static String runTest(int n) {
		int fibNum;
		long tempTime = System.nanoTime();
                if (n > 45 || n < 0)
                    throw new NumberFormatException("Number needs to be greater than 0 or less then 45.");
		fibNum = fibRecur(n);
		long time = System.nanoTime() - tempTime;
		return "Found " + fibNum + " in " + time + " nanoseconds.";
	}

}