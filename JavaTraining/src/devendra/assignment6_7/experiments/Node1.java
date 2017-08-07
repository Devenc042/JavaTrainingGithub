package devendra.assignment6_7.experiments;

public class Node1 {
	
	protected int data;
	protected Node1 next;

	Node1(){
		data = 0;
		next = null;
	}
	Node1(int data, Node1 next){
		this.data = data;
		this.next = next;
	}
	
	public int getData() { return this.data;}
	public Node1 getlink() { return this.next;}
}
