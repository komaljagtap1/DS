package net.codejava;

public class CircularLL {

 Node last; 
 
 // Node is a static nested class
 // so main() can access it
 static class Node {
     int data;
     Node next;
     // Constructor
     Node(int d)
     {
         data = d;
         next = null;
     }
 }
 
 public void insert_first(int data)
 {
   // Create a new node with given data
   Node new_node = new Node(data);
   if(last==null)
   {
	   last=new_node;
	   last.next=last;
	   return;
   }
   new_node.next=last.next;
   last.next=new_node;
   //last=new_node;
   return;
}
 
 
 
 public void insert_last(int data)
{
  // Create a new node with given data
  Node new_node = new Node(data);
  if (last == null) {
      last = new_node;
      last.next=new_node;
  }
  else {
	new_node.next=last.next;
	last.next=new_node;
	last=new_node;
	
   }
   return;
}

 public void addafter(int data,int item)
 {
 	Node nn,p;
 	p=last.next;
 	do
 	{
 		if(p.data==item)
 		{
 			nn=new Node(data);
 			nn.next=p.next;
 			p.next=nn;
 			if(p==last)
 				last=nn;
 			return;
 		}
 		p=p.next;
 	}while(p!=last.next);
 	System.out.println("Not Found");
 	return;
 }/*End of addafter()*/
 
public void display()
{
	Node p;
	if(last==null)
	{
		System.out.println("List is empty");
		return;
	}
	p=last.next;
	do 
	{
		System.out.print(p.data + " ");
		p=p.next;
	}while(p!=last.next);
	System.out.println(" ");
}/*End of display( )*/

public static void main(String []s)
{
	CircularLL l1=new CircularLL();
	l1.insert_last(10);
	l1.insert_last(20);
	l1.insert_last(30);
	l1.insert_last(40);
	l1.insert_first(50);
	l1.addafter(600,30);
	
	l1.display();
	
}
}