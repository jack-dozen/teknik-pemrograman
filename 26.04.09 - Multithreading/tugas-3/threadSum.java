import java.util.Scanner;

class sum implements Runnable{
	private final int startNum, endNum;
	private int partialSum = 0;

	public sum(int startNum, int endNum){
		this.startNum = startNum;
		this.endNum = endNum;
	}

	@Override
	public void run(){
		for (int i = startNum; i <= endNum; i++)
			partialSum += i;
	}

	public int getPartialSum(){
		return partialSum;
	}
}

public class threadSum{
	public static void main(String[] args){
		int numThreads, endNum;

		Scanner sc = new Scanner(System.in);

		System.out.print("NUM_THREAD: ");
		numThreads = sc.nextInt();
		System.out.print("END_NUM: ");
		endNum = sc.nextInt();

		sc.close();

		int chunkSize = endNum / numThreads;

		Thread[] threads = new Thread[numThreads];
		sum[] workers = new sum[numThreads];
		int[] starts = new int[numThreads];
		int[] ends = new int[numThreads];

		for(int i = 0; i < numThreads; i++){
			int start = (i * chunkSize) + 1;
			int end = (i == numThreads - 1) ? endNum :  (i+1) * chunkSize;

			starts[i] = start;
			ends[i] = end;

			sum worker = new sum(start, end);  
			Thread t = new Thread(worker);
			t.start();

			threads[i] = t;
			workers[i] = worker;
		}

		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {}
		}

		int total = 0;

		System.out.println("=== RESULT ===");

		for(int i = 0; i < numThreads; i++){
			int partialSum = workers[i].getPartialSum();
			System.out.println("Thread[" + i +"] (" + starts[i] + " - " + ends[i] + ") : " + partialSum);
			total += partialSum;
		}

		System.out.println("TOTAL: " + total);
	}
}
