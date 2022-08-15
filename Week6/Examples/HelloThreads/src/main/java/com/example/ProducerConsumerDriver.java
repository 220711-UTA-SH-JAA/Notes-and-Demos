package com.example;

import java.util.LinkedList;

import com.example.threads.ConsumerRunnable;
import com.example.threads.Producer;

public class ProducerConsumerDriver {

	public static void main(String[] args) {
		
		LinkedList<Integer> buffer = new LinkedList<>();
		
		//Lets create our threads
		Producer producer = new Producer(buffer);
		
		ConsumerRunnable consumerRunnable = new ConsumerRunnable(buffer);
		Thread consumer = new Thread(consumerRunnable);
		
		//Start the producer and the consumer
		producer.start();
		consumer.start();
		
		//Try to the child threads back into main when they are done
		try {
			producer.join();
			consumer.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
