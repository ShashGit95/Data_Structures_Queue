import java.util.*;
class Queue{
    private int[] dataArray;
    private int intSize;
    private float loadFactor;
    private int nextIndex;

    Queue(int intSize, float loadFactor){
        dataArray=new int[intSize];
        this.intSize=intSize;
        this.loadFactor=loadFactor;
    }
    private boolean isEmpty(){
        return nextIndex<=0;
    }
    private boolean isFull(){
        return nextIndex>=dataArray.length;
    }
    public void enQueue(int data){
        if(isFull()){
            extendsArray();
        }
        dataArray[nextIndex++]=data;
    }
    private void extendsArray(){
        int[]tempDataArray=new int[dataArray.length+(int)(dataArray.length*loadFactor)];
        for (int i = 0; i < dataArray.length; i++){
            tempDataArray[i]=dataArray[i];
        }
        dataArray=tempDataArray;
    }
    public void deQueue(){
        if(!isEmpty()){
            for (int i = 0; i < nextIndex-1; i++){
                dataArray[i]=dataArray[i+1];
            }
            nextIndex--;
        }
    }
    public void printQueue(){
        System.out.print("[");
        for (int i = 0; i < nextIndex; i++)	{
            System.out.print(dataArray[i]+", ");
        }
        System.out.println(isEmpty()?"empty]":"\b\b]");
    }
	/*
	public String toString(){

	}
	public int size(){

	}
	public int peek(){

	}
	public int poll(){

	}
	public int[] toArray(){

	}
	public int search(int data){

	}
	public void clear(){

	}
	*/
}
class Demo{
    public static void main(String args[]){
        Queue q1=new Queue(100,0.25f);
        q1.enQueue(10);
        q1.enQueue(20);
        q1.enQueue(30);
        q1.enQueue(40);
        q1.enQueue(50);
        q1.printQueue(); //[10,20,30,40,50]

        q1.deQueue();
        q1.printQueue(); //[20,30,40,50]
    }
}




