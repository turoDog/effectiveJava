package item_66.fixedstopthread1;

import java.util.concurrent.TimeUnit;

public class StopThread {
	private static boolean stopRequested;
	
	private static synchronized void requestStop() {
		stopRequested = true;
	}
	
	private static synchronized boolean stopRequested() {
		return stopRequested;
	}
	
	public static void main(String[] args) {
		Thread backgroundThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while (!stopRequested()) {
					i++;
					
				}
			}
		});
		backgroundThread.start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		requestStop();
	}

}
