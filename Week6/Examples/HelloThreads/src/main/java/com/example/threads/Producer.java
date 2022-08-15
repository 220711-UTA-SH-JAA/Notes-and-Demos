package com.example.threads;

import java.util.LinkedList;

public class Producer extends Thread {
	
	//Shared Buffer, we are using a linked list, because arraylists are not thread safe
	private final LinkedList<Integer> buffer;
	
	//The amount of items to store in our buffer
	private final int SIZE = 10;
	
	public Producer(LinkedList<Integer> buffer) {
		this.buffer = buffer;
	}
	
	private void produce(int i) throws InterruptedException {
		//Since we are sharing the buffer, we need to put it in a synchronized block
		synchronized(buffer) {
			//If the buffer is full, we will wait
			while(buffer.size() == SIZE) {
				System.out.println("Buffer is full, waiting...");
				buffer.wait();
			}
			
			buffer.add(i);
			
			//This will send a message to all threads that have access to the shared buffer, that some change occured
			buffer.notifyAll();
		}
	}
	
	@Override
	public void run() {
		for(int i=0; i<SIZE; i++) {
			System.out.println("Producing: " + (i+1));
			try {
				this.produce(i+1);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
