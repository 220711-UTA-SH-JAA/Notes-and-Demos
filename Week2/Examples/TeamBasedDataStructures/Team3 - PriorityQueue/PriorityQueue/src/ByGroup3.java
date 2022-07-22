import java.util.*;

public class ByGroup3 {
	
	private Person[] queue;
	private int size;
	
    public ByGroup3(){
		queue = new Person[10];
		size = 0;
	}
    
    public void add(Person p) {
    	size++;
    	if(size > queue.length) {
    		int newSize = (int) (queue.length * 1.5);
    		Person[] temp = new Person[newSize];
    		for(int i = 0; i < queue.length; i++) {
    			temp[i] = queue[i];
    		}
    		queue = temp;
    	} 
    	queue[size - 1] = p;		
    }
    
    private int findHighestPriority() {
    	int highest = -1;
    	int highestIndex = 0;
    	for(int i = 0; i < size; i++) {
    		if(queue[i].tier > highest) {
    			highest = queue[i].tier;
    			highestIndex = i;
    		}
    	}
    	return highestIndex;
    }

	
	// Poll method
	public Person poll() {
		int index = findHighestPriority();
		Person removed = queue[index];
		for(int i = index; i < size - 1; i++) {
			queue[index] = queue[index + 1];
		}
		size--;
		return removed;
	}
	
	
	// Peek method
	public Person peek() {
		int index = findHighestPriority();
		return queue[index];
	}

	
	public String toString() {
		
		String result = "";
		for(int i = 0; i < size; i++) {
			result += queue[i].getName() + " ";
		}
		return result;
	};
	
	
	public static void main(String[] args) {
		
		Person a1 = new Person(0, "etha");
		Person a2 = new Person(5, "jasnin");
		Person a3 = new Person(7, "larr");
		Person a4 = new Person(3, "jame");
		Person a5 = new Person(6, "victo");
		Person a6 = new Person(2, "gen");
		Person a7 = new Person(4, "edwi");
		
		ByGroup3 priorityQueue = new ByGroup3();
		priorityQueue.add(a3);
		priorityQueue.add(a5);
		System.out.println(priorityQueue.peek().name);
//		System.out.println(priorityQueue);
		System.out.println(priorityQueue.poll().name);
		System.out.println(priorityQueue.poll().name);
	}	
	
	
	
}

class Person {
	int tier;
	String name;

	public Person(int tier, String name) {
		this.tier = tier;
		this.name = name;
	}
	
	public int getTier() {
		return this.tier;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setTier(int newTier) {
		this.tier = newTier;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
}
