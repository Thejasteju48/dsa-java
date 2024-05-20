package Linkedlist.CircularSinglylist;
import java.util.Scanner;
 class Node{
     int data;
     Node next;
    public Node(int data)
    {
     this.data = data;
     this.next = null;
    }
 }
public class Csll{
    private Node head;
    private Node tail;
    Scanner sc = new Scanner(System.in);
     public void Createlist()
     {
        System.out.println("Enter the value of head node");
        int data = sc.nextInt();
        head = new Node(data);
        Node current = head;
        Node temp = null;
        Node newnode = null;
        int i = 1;
        while(current!=null)
        {
            System.out.println("Enter -1 to end list");
            System.out.println("Enter the value of "+(i+1)+"th node :");
            data = sc.nextInt();
            if(data!=-1)
            {
            newnode = new Node(data);
            current.next = newnode;
            current = current.next;
            }
            else{
               temp =current;
               current = null;
            }
            i++;
        }
        tail = temp;
        temp.next = head;
     }
     public void display()
     {
      Node current = head;
      if(head==null)
      {
         System.out.println("Empty list");
         return;
      }
      do{
           System.out.println(current.data);
           current = current.next;
      }while(current!=head);
     }
     public int findlenght()
     {
           Node current = head;
           int count = 0;
           if(head == null)
           {
            return 0;
           }
           do {
                 count++;
               current = current.next;
           } while (current!=head);
           return count;
     }
     public void insertAthead(int data)
     {
        Node newnode = new Node(data);
        if(head == null)
        {
            head = newnode;
            head.next = head;
            tail = newnode;
            return;
        }
        Node current = head;
        newnode.next = current;
        while (current.next!=head){
           current = current.next;
        }
        current.next = newnode;
        head = newnode;
        
     }
     public void insertAttail(int data)
     {
      Node newNode = new Node(data);
      Node current = head;
      if(head==null)
      {
          head = newNode;
          head.next = head;
          tail = newNode;
          return;
      }
      while (current.next!=head){
         current = current.next;
      }
      newNode.next=current.next;
      current.next = newNode;
     }
     public int  deleteAthead()
     {
        if(head==null)
        {
         System.out.println("Empty list deletion not possible");
         return -1;
        }
        Node current = head;
        int val;
        Node temp = current;
        while (current.next!=head) {
         current = current.next;
        }
        current.next = temp.next;
        head = current.next;
        val = temp.data;
        return val;
        
     }
     public int deleteAttail()
     {
        if(head==null)
        {
         System.out.println("Empty list deletion not possible");
         return -1;
        }
        int val;
        Node current = head;
        Node temp = null;
        while (current.next!=head){
           temp = current;
           current = current.next;
        }
        temp.next = current.next;
        val = current.data;
        return val;
     }
     
    public void insertByposition(int pos,int val)
    {
      if(pos<1 || pos>findlenght()+1)
      {
         System.out.println("Invalid position insertion not possible");
         return;
      }
      int count = 1;
      Node current = head;
      Node newnode = new Node(val);
      Node temp = null;
      if(pos == 1)
      {
         insertAthead(val);
      }
      else if(val == findlenght()+1)
      {
         insertAttail(val);
      }
      else{
             while (count<pos){
               temp = current;
               current = current.next;
               count++;
             }
             newnode.next = current;
             temp.next = newnode;
      }
    }
    public int deletebypostion(int pos)
    {
      if(pos<1||pos>findlenght()+1)
      {
         System.out.println("Invalid postion deletion not possible");
         return -1;
      }
      int count = 1;
      int val;
      Node current = head;
      Node temp = null;
      if(pos == 1)
      {
        val = deleteAthead();
      }
      else if(pos ==findlenght()+1)
      {
         val = deleteAttail();
      }
      else
      {
         while (count<pos){
            temp = current;
            current = current.next;
            count++;
         }
         temp.next = current.next;
         val = current.data;
         current = null;
      }
      return val;
    }
    public int deletebykey(int key)
    {
      if(head==null)
      {
         System.out.println("Empty list deletion not possible");
         return -1;
      }
      Node current = head;
      int count = 1;
      int val ;
      do {
             if(current.data==key)
             {
                val = deletebypostion(count);
                return val;
             }
             current = current.next;
             count++;
      } while (current!=head);
      return -1;
    }
    public void createorderlist(int val)
    {
      Node newnoNode = new Node(val);
      if(head==null)
      {
         head = newnoNode;
         head.next = newnoNode;
         tail = head;
         return;
      }
      Node current = head;
      int count = 1;
      do {
           if(val<current.data)
           {
              insertByposition(count, val);
              return;
           }
           current = current.next;
           count++;
      } while (current!=head);
    }
    public void freelist()
    {
      head = null;
    }
    public void reverselist()
    {
      Node current = head;
      Node prev = null;
      Node next = null;
      while(current.next!=head)
      {
         next = current.next;
         current.next = prev;
         prev = current;
         current = next;
      }
      head.next = current;
      tail = head;
      head = current;
      current.next = prev;
    }
     public static void main(String args[])
     {
         Csll list = new Csll();
         Scanner sc = new Scanner(System.in);
         int val,pos,choice,key;
         Node temp = null;
         do{
            System.out.println("1.FINDLENGTH");
            System.out.println("2.INSERTATHEAD");
            System.out.println("3.INSERTATTAIL");
            System.out.println("4.DELETEATHEAD");
            System.out.println("5.DELETEATTAIL");
            System.out.println("6.INSERTBYPOSITITON");
            System.out.println("7.DELETEBYPOSTION");
            System.out.println("8.DELETEBYKEY");
            System.out.println("9.CREATEORDERDLIST");
            System.out.println("10.REVERSELIST");
            System.out.println("11.EXIT");
            System.out.println("Enter your choice of operation :");
            choice = sc.nextInt();
            switch (choice) {
               case 1:
                        list.Createlist();
                        System.out.println("The length of list is "+list.findlenght());
                        list.display();   
                        list.freelist();               
                        break;
               case 2:
                        list.Createlist();
                        System.out.println("Enter the value to be inserted");
                        val = sc.nextInt();
                        list.insertAthead(val);
                        list.display();
                        list.freelist();
                        break;
               case 3:
                       list.Createlist();
                       System.out.println("Enter the value to be inserted");
                       val = sc.nextInt();
                       list.insertAttail(val);
                       list.display();
                       list.freelist();
                       break;
               case 4:
                      list.Createlist();
                      val = list.deleteAthead();
                      if(val!=-1){
                      System.out.println(val+" is deleted from list");
                      }
                      list.display();
                      list.freelist();
                      break;
               case 5:
                      list.Createlist();
                      val = list.deleteAttail();
                      if(val!=-1)
                      {

                        System.out.println(val+" is deleted from list");
                      }
                      list.display();
                      list.freelist();
                      break;
               case 6:
                       list.Createlist();
                       System.out.println("Enter the postion and its value to be inserted");
                       pos = sc.nextInt();
                       val =sc.nextInt();
                       list.insertByposition(pos, val);
                       list.display();
                       list.freelist();
                       break;
               case 7:
                       list.Createlist();
                       System.out.println("Enter the postion to be deleted");
                       pos = sc.nextInt();
                       val =list.deletebypostion(pos);
                       if(val!=-1)
                       {
                        System.out.println(val+" is deleted from postion "+pos);
                       }
                       list.display();
                       list.freelist();
                       break;
               case 8:
                      list.Createlist();
                      System.out.println("Enter the key value to be deleted");
                     key = sc.nextInt();
                      val = list.deletebykey(key);
                      if(val!=-1)
                      {
                        System.out.println(val+" is deleted from list");
                      }
                      list.display();
                      list.freelist();
                      break;
               case 9:
                      list.Createlist();
                      System.out.println("Enter the value to be inserted");
                      val = sc.nextInt();
                      list.createorderlist(val);
                      list.display();
                      list.freelist();
                      break;
               case 10:
                       list.Createlist();
                       list.reverselist();
                       list.display();
                       list.freelist();
                       break;
               case 11:
                      System.out.println("--Exiting--");
                      break;
            
               default:
                        System.out.println("Invalid choice");
                  break;
            }
         }while(choice!=11);
     }
    
}
