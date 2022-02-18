package week4;



public class LinkedList {
	public static class Node{
		int data;
		Node next;
		Node(int data){
		this.data=data;
		this.next=null;
		}
		}
		Node head=null;
		Node tail=null;
		public void addNode(int data) {
		if(head==null) {
		Node newnode =new Node(data);
		head=newnode;
		tail=head;
		}
		else {
		Node newnode=new Node(data);
		tail.next=newnode;
		tail=newnode;

		}

		}
		public void printList() {
		Node current=head;
		while(current!=null) {
		System.out.println(current.data);
		current=current.next;
		}
		}
		public int Size() {
		int size=0;
		Node current=head;
		while(current!=null) {
		size++;
		current=current.next;
		}
		return size;
		}
		public int getDataByIndx(int i) {
		Node current=head;
		if(Size()==0 || i>Size()) {
		System.out.println("invalid index or linked list has no element");
		return -99999;
		}
		else {
		for(int j=1;j<i;j++) {
		current=current.next;
		}
		return current.data;
		}

		 }

}
