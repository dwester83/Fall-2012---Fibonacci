public class NonRecursiveFib {

	public NonRecursiveFib() {
		super();
	}

	public static String fibTime(int n) {
		if (n > 45 || n < 0)
			throw new NumberFormatException(
					"Number needs to be greater than 0 or less then 45.");

		long startTime = System.nanoTime();

		int number = fib(n);

		long estimatedTime = System.nanoTime() - startTime;

		return ("Found " + number + " in " + estimatedTime + " nanoseconds.");
	}

	private static int fib(int n) {
		int value = 1, next = 1, prev = 0;

		for (int i = 0; i < n; i++) {
			prev = value;
			value = next;
			next += prev;
		}

		return value;
	}

}
