package edu.ewu.ytian.prime;

public class MyPrimeTest {


	public static void main(String[] args) throws InterruptedException {
		if (args.length < 3) {
					System.out.println("Usage: MyPrimeTest numThread low high \n");
					return;
				}
		int nthreads = Integer.parseInt(args[0]); // number of threads
		int low = Integer.parseInt(args[1]);
		int high = Integer.parseInt(args[2]);
		int partition = (high - low) / nthreads;
		Counter c = new Counter();

		
		//test cost of serial code
		long start = System.currentTimeMillis();
		int numPrimeSerial = SerialPrime.numSerailPrimes(low, high);
		long end = System.currentTimeMillis();
		long timeCostSer = end - start;
		System.out.println("Time cost of serial code: " + timeCostSer + " ms.");
		

		//test of concurrent code
		final ThreadManager tm = new ThreadManager(low, high, c, nthreads, partition);

		start = System.currentTimeMillis();
		Thread t1 = new Thread() {
			public void run() {
				tm.t1.start(); // join t1 to threadmanager
				try {
					tm.t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.start();
		try {
			t1.join(); // join main to t1 which is starting the thread manager
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		
		
		// **************************************
		long timeCostConcurrent = end - start;
		System.out.println("Time cost of parallel code: " + timeCostConcurrent + " ms.");
		System.out.format("The speedup ration is by using concurrent programming: %5.2f. %n", (double)timeCostSer / timeCostConcurrent);
		
		System.out.println("Number prime found by serial code is: " + numPrimeSerial);
		System.out.println("Number prime found by parallel code is " + c.total());

		
	}


}
	
		
	


