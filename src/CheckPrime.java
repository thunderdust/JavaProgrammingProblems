
/* Determine if a given number is prime */
public class CheckPrime {

	public static void main(String args[]) {

		for (int i = 0; i < 20; i++) {
			if (isPrimeFast(i)) {
				System.out.println(i + " is prime.");
			} else {
				System.out.println(i + " is NOT prime.");
			}
		}
	}

	public static boolean isPrime(int number) {

		if (number < 2)
			return false;
		int i = 2;
		while (i <= number / 2) {
			if (number % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}

	/*
	 * With some more efficient coding, we notice that you really only have to
	 * go up to the square root of n, because if you list out all of the factors
	 * of a number, the square root will always be in the middle (if it happens
	 * to not be an integer, we're still ok, we just might over-approximate, but
	 * our code will still work). Finally, we know 2 is the "oddest" prime - it
	 * happens to be the only even prime number. Because of this, we need only
	 * check 2 separately, then traverse odd numbers up to the square root of n
	 */
	public static boolean isPrimeFast(int n) {
		if (n < 2)
			return false;
		if (n == 2)
			return true;
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
