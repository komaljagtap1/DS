
//write the class in your package for data_structures
public class LinkedList{

 Node head; 
 
 /* Node is a static nested class, so main() can access it,  you can write it as seperate class in same package */
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

 public void insert_last(int data)
 {

     Node new_node = new Node(data);
     
     if (head == null) {
         head = new_node;
     }
     else {
         Node last = head;
         while (last.next != null) {
             last = last.next;
         }
         last.next = new_node;
     }
}

 
public void insert_first(int data)
{
	Node new_node = new Node(data);

	if (head == null) {
		head = new_node;
	}
	else {

    new_node.next=head;
    head=new_node;
}


}

 public void insert_by_pos(int data,int pos)
{

Node new_node = new Node(data);
if (head == null) {
head = new_node;
}
else {
	if(pos==1)
	{
		new_node.next=head;
	    head=new_node;
	}
	else {
	Node temp=head;
	for(int i=1;i<pos-1;i++)
	{
		if(temp.next==null)
			break;
		temp=temp.next;
	}
    new_node.next=temp.next;
    temp.next=new_node;
    }
}
}
 
/*function for merging 2 lists one after another*/
public static LinkedList merge_list(LinkedList l1,LinkedList l2)
 {
	 Node temp=l1.head;
	 while(temp.next!=null)
		  temp=temp.next;
	 temp.next=l2.head;
	 return l1;
 }
 

 public void delete_first()
 {
	 head=head.next;
 }
 

 public void delete_last()
 {
	 Node temp=head;
	 while(temp.next.next!=null)
	 {
		 temp=temp.next;
	 }
	 temp.next=null;
}
 

 public void delete_by_pos(int pos)
 {
	 Node temp=head;
	 Node prev=temp;   //maintain prev node and use it to set link 
	 if(pos==1)
	 {
		 head=head.next;
		 return;
	 }
	 for(int i=1;i<pos;i++)
	 {
		 prev=temp;
		 if(temp.next.next==null)
			 break;
		 temp=temp.next;
	 }
	 prev.next=temp.next;
	 return;
}
 
 
 public void display()
 {
     Node temp = head;
     System.out.print("LinkedList: ");
     while (temp != null) {
         System.out.print(temp.data + " ");
         temp = temp.next;
     }
     System.out.print("\n");
 }

 public void Sort_List_byData()
 {
	  Node temp1=head;
	  Node temp2;
	  
	  for( ; temp1.next!=null;temp1=temp1.next)
	  {
		  for(temp2=temp1.next;temp2!=null;temp2=temp2.next)
		  {
			  if(temp1.data>temp2.data)
			  {
				  int t=temp1.data;
				  temp1.data=temp2.data;
				  temp2.data=t;
			  }
		  }
	  }
	  return;
 }
 
 
 public static LinkedList merge_sortedLists(LinkedList l1,LinkedList l2)
 {
	LinkedList mergeLL=new LinkedList();
	Node temp1=l1.head;
	Node temp2=l2.head;
	while((temp1!=null)&&(temp2!=null))
	{
		if(temp1.data<temp2.data)
		{
			mergeLL.insert_last(temp1.data);
			temp1=temp1.next;
		}
		else if(temp2.data < temp1.data)
		{
			mergeLL.insert_last(temp2.data);
			temp2=temp2.next;
		}
		else
		{
			mergeLL.insert_last(temp1.data);
			temp1=temp1.next;
			temp2=temp2.next;
		}
	}
	while(temp1!=null)  //loop for remaining nodes of temp1
	{
		mergeLL.insert_last(temp1.data);
		temp1=temp1.next;
	}
	while(temp2!=null) //loop for remaining nodes of temp2
	{
		mergeLL.insert_last(temp2.data);
		temp2=temp2.next;
	}
	return mergeLL;
}
 
 public static void main(String[] args)   //try and call all possible methods in main 
 {
     
     LinkedList head = new LinkedList();
     LinkedList head2 = new LinkedList();
          
     head.insert_last(10);
     head.insert_last(2);
     head.insert_last(30);
     head.insert_last(6);
     head.insert_last(18);
     head.insert_by_pos(100,4);
     head.insert_first(50);
     head.display();
    
     
     head2.insert_last(21);
     head2.insert_last(12);
     head2.insert_last(3);
     head2.display();
     head.Sort_List_byData();
     head2.Sort_List_byData();
     System.out.println("After sorting : ");
     head.Sort_List_byData();
     head2.Sort_List_byData();
     head.display();
     head2.display();
     LinkedList head3=merge_sortedLists(head,head2);
     System.out.println("After merging : ");
     head3.display();
     head2.delete_by_pos(5);
     head3.display();
     
 }
}