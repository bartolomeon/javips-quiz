package pl.consileon.javips.quiz.threads;

public class ThreadStopper {

	static class CountingThread extends Thread {

		private boolean justStopIt = false;
		private long counter = 0;

		public void run() {
			while (!justStopIt) {
				++counter;
			}

			System.out.println("Counted to: " + counter);
		}

		public void stopIt() {
			this.justStopIt = true;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CountingThread t = new CountingThread();
		t.start();
		Thread.sleep(1000);
		t.stopIt();
		System.out.println("Asked to stop.");
		Thread.sleep(2000);
		
		if (t.isAlive()) {
			System.out.println("But it didn't work...");
		} else {
			System.out.println("and it worked!");
		}
	}
}
