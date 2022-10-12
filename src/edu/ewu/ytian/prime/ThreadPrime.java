package edu.ewu.ytian.prime;

public class ThreadPrime extends Thread {
	private int low;
	private int high;
	private int numFound = 0;
	private Counter c;
	private Counter threadsDone;

	
	// each thread only  takes care of one subrange (low, high)
	public ThreadPrime (int lowLocal, int highLocal, Counter ct, Counter threadsDone) {
		this.low = lowLocal;
		this.high = highLocal;
		this.c = ct;
		this.threadsDone = threadsDone;
	}

	public void run(){
		for (int i = low; i <= high; i++) {
			if (SerialPrime.isPrime(i)) {
				numFound++;
			}
		}
		c.increment(numFound);
		threadsDone.increment(1);

	}

	public static boolean isPrime(int n) {
		 //check if n is a multiple of 2
		 if (n%2==0) return false;
		 //if not, then just check the odds
		 for(int i=3;i*i<=n;i+=2) {
			 if(n%i==0)
				 return false;
		 }
		 return true;
	}

}
