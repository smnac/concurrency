
public class CPUHogger {

	static class CPUHog extends Thread
	{
		@Override
		public void run() {
			
			while(true) {
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(Thread.activeCount());
		
		
		for(int i=0;i<6;i++)
			new CPUHog().start();
			
				
		System.out.println(Thread.activeCount());
		

	}

}

