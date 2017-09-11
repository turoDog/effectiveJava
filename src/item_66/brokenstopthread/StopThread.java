package item_66.brokenstopthread;

import java.util.concurrent.TimeUnit;

public class StopThread {
	private static boolean stopRequested;
	
	public static void main(String[] args) {
		Thread backgroundThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while (!stopRequested)
					i++;
			}
		});
		backgroundThread.start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		stopRequested = true;
	}

}
