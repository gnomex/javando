package br.github.gnomex.two_th_exercises.multithread;

import java.util.Random;

public class Consumer implements  Runnable{

	private Random rand = new Random();
	private MultiThreadListBuffer buffer;

	public Consumer(MultiThreadListBuffer buffer){
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while(!iGotIt())	{
			try {
				int inTime = buffer.get();
				System.out.println("Lol, I got: " + inTime + " just now!!!");

				Thread.sleep((long) rand.nextInt(800));
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
		return rand.nextInt(1000) == 1 ? Boolean.TRUE : Boolean.FALSE;
	}
}
