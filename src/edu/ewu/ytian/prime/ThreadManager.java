package edu.ewu.ytian.prime;

public class ThreadManager {

    private int nthreads;
    int low;
    int high;
    private Counter c;
    private ThreadPrime[] threads;
    int partition;
    private Counter threadsDone = new Counter();

    protected Thread t1 = new Thread() {
        public void run() {
            for (int i = 0; i < nthreads; i++) {
                threads[i].start();
            }
            while (threadsDone.total() < nthreads) {}
        }
    };

    public ThreadManager(int low, int high, Counter ct, int nthreads, int partition) {
        this.nthreads = nthreads; // number of threads
        this.low = low;
        this.high = high;
        this.c = ct;
        this.partition = partition;
        threads = new ThreadPrime[nthreads];
        for (int i = 0; i < nthreads; i++) {
            threads[i] = new ThreadPrime((partition * i)+1, (partition * i)+partition, c, threadsDone); 
        }
    }

    public int total() {
		return c.total();
	}



}
