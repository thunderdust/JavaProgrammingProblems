/* Count the number of prime numbers less than a non-negative number, n.
 * Try to be efficient (Better than O(n^2)). */

/* [the sieve of Eratosthenes] one of a number of prime number sieves, 
 * is a simple, ancient algorithm for finding all prime numbers up to 
 * any given limit. It does so by iteratively marking as composite 
 * (i.e., not prime) the multiples of each prime, starting with the 
 * multiples of 2 */

public class CountPrime {

	public static void main(String args[]) {
		int n = 20;
		System.out.println("Number of primes under " + n + ": " + countPrime(n));

	}

	public static int countPrime(int n) {

		// initially assume all integers are prime
		boolean[] primeCheck = new boolean[n];
		for (int i = 2; i < n; i++) {
			primeCheck[i] = true;
		}
		int count = 0;
		// mark non-primes <= N using Sieve of Eratosthenes
		for (int i = 2; i * i < n; i++) {
			if (primeCheck[i]) {
				for (int j = i; j * i < n; j++) {
					primeCheck[i * j] = false;
				}
			}
		}
		// count primes
		for (int i = 2; i < n; i++) {
			if (primeCheck[i]) {
				count++;
			}
		}
		return count;
	}

	public static boolean isPrime(int n) {
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
