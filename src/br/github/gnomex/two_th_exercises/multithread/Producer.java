package br.github.gnomex.two_th_exercises.multithread;

import java.util.Random;

public class Producer implements Runnable{
	private Random rand = new Random();
	private MultiThreadListBuffer buffer;

	public Producer(MultiThreadListBuffer buffer){
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while(!iGotIt())	{
			try {
				int inTime = rand.nextInt(20);
				System.out.println("Putting: " + inTime);
				buffer.set(new Integer(inTime));

				Thread.sleep((long) rand.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Bye!");

	}

	private Boolean iGotIt()	{
		return rand.nextInt(3000) > 2800 ? Boolean.TRUE : Boolean.FALSE;
	}
}
