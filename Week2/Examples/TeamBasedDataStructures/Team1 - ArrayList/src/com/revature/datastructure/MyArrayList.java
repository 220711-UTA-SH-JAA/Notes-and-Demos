

package com.revature.datastructure;

public class MyArrayList<T> {
    private T[] dataArray;

    private int size;
    public MyArrayList(){
        //give array list default size of 10
        this(10);
    }

    public MyArrayList(int size){
    	
        this.size = 0;
        this.dataArray = (T[]) new Object[size];
    }

    private void increaseSize() {
    	int newSize = dataArray.length + dataArray.length/2;   	
    	T[] newArray = (T[])new Object[newSize];
    	for ( int i=0; i<dataArray.length; i++) {
    		newArray[i] = dataArray[i];
    	}
    	dataArray = newArray;
    }
   
    public boolean add(T data){
    	 if (size>=dataArray.length/2){
             increaseSize();
         }
         dataArray[size++] = data;
        return true;
    }
    public void add(int index, T data){
    	if (size>=dataArray.length/2){
            increaseSize();
    	}
    	int i = size+1;
    	for (; i > index; i--) {
    		dataArray[i] = dataArray[i-1];
    	}
    	dataArray[i] = data;
    	size++;
    }
    public boolean remove(T data){
        int index = objectIn(data);
        if(index < 0) return false;
        remove(index);
    	return true;
    }

    public void remove(int index){
        for(int i = index; i<size; i++){
            dataArray[i] = dataArray[i+1];
        }
        size--;
    }

    public int size(){return size+1;}

    private int objectIn(T data){
        for(int i = 0; i<size; i++)
            if(dataArray[i].equals(data)) return i;
        return -1;
    }
    public boolean contains(T data){
        for(int i = 0; i<size; i++){
            if(dataArray[i].equals(data)) return true;
        }
        return false;
    }

    //public T[] toArray(){ return dataArray;}

    @Override
    public String toString(){ 
    	
    	StringBuilder stringBuilder = new StringBuilder();
    	for ( int i = 0; i<this.size; i++) {
    		stringBuilder.append(dataArray[i].toString());
            stringBuilder.append(" ");
    	}
    	return stringBuilder.toString();
   
    
    }
}